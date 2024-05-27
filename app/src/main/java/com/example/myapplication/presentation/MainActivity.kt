package com.example.myapplication.presentation

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    @Composable
    private fun AppScreen(state: State<MainState?>) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val time = remember { mutableStateOf(0) }

            val scope = rememberCoroutineScope()

            LaunchedEffect(key1 = time.value) {
                scope.launch {
                    delay(1000)
                    time.value++
                }
            }

            Column {
                Text(
                    text = "Профиль",
                    fontSize = 32.sp
                )
                Spacer(modifier = Modifier.height(54.dp))

                Text(
                    text = "Имя ${state.value?.name}",
                    fontSize = 24.sp
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Фамилия ${state.value?.lastName}",
                    fontSize = 24.sp
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Кол-во друзей ${state.value?.friendCount}",
                    fontSize = 24.sp
                )
                Spacer(modifier = Modifier.height(12.dp))
                Button(
                    onClick = {
                        viewModel.incCount()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Text(text = "${state.value?.count}")
                }
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Time ${time.value}",
                    fontSize = 24.sp
                )
            }
        }
    }

    @Composable
    fun SampleScreen() {
        Scaffold(
            topBar = {
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(Color.Cyan)) {
                    Text(text = "TopBar")
                }
            },
            bottomBar = {
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(Color.Yellow)) {
                    Text(text = "BottomBar")
                }
            }
        ) {
            val count = remember { mutableStateOf(0) }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                Button(
                    onClick = { count.value++ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .align(Alignment.Center)
                ) {
                    Text(text = "${count.value}")
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val state = viewModel.state.collectAsState()

            MyApplicationTheme {
//                SampleScreen()
                AppScreen(state)
            }
        }
    }

}