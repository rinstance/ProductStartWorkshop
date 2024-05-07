package com.example.myapplication.presentation

import android.app.DownloadManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.example.myapplication.ui.theme.MyApplicationTheme
import java.io.File

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val name = viewModel.name.collectAsState()
            val lastName = viewModel.lastName.collectAsState()
            val count = viewModel.count.collectAsState()

//            val state = viewModel.state.collectAsState()

            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        Text(
                            text = "Профиль",
                            fontSize = 32.sp
                        )
                        Spacer(modifier = Modifier.height(54.dp))

                        Text(
                            text = "Имя ${name.value}",
                            fontSize = 24.sp
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = "Фамилия ${lastName.value}",
                            fontSize = 24.sp
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = "Кол-во друзей ${count.value}",
                            fontSize = 24.sp
                        )
                    }
                }
            }
        }
    }

}