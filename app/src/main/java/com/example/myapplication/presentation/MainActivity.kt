package com.example.myapplication.presentation

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import coil.compose.SubcomposeAsyncImage
import coil.load
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    @Composable
    private fun ProfileImage(url: String?) {
        SubcomposeAsyncImage(
            model = url,
            contentDescription = null,
            modifier = Modifier
                .size(104.dp)
                .clip(CircleShape)
        )
    }

    //for xml
//    override fun onStart() {
//        super.onStart()
//        val image = findViewById<ImageView>(R.id.image)
//
//        lifecycleScope.launch {
//            viewModel.state.collect {
//                it?.image?.let { url ->
//                    image.load(url) {
//                        error(ColorDrawable(Color.RED))
//                    }
//                }
//            }
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        setContent {
            MyApplicationTheme {
                val state = viewModel.state.collectAsState()
                ProfileImage(url = state.value?.image)
            }
        }
    }

}