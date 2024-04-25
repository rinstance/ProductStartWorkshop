package com.example.myapplication

import android.app.DownloadManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.example.myapplication.ui.theme.MyApplicationTheme
import java.io.File


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        Text(
                            text = "Start",
                            fontSize = 20.sp,
                            modifier = Modifier.clickable { startService("Started") }
                        )
                        Spacer(modifier = Modifier.height(30.dp))
                        Text(
                            text = "Stop",
                            fontSize = 20.sp,
                            modifier = Modifier.clickable { stopService() }
                        )
                        Spacer(modifier = Modifier.height(30.dp))
                        Text(
                            text = "Download",
                            fontSize = 20.sp,
                            modifier = Modifier.clickable { download() }
                        )
                    }
                }
            }
        }
    }

    private fun download() {
        val fileUrl = "http://speedtest.ftp.otenet.gr/files/test10Mb.db"
        val fileName = "test10Mb.db"

        val request = DownloadManager.Request(Uri.parse(fileUrl))
            .setTitle(fileName)
            .setDescription("Downloading")
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
            .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName)

        val downloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        downloadManager.enqueue(request)
    }

    private fun startService(input: String) {
        val myServiceIntent = Intent(this, MyForegroundService::class.java)
        myServiceIntent.putExtra(Constants.inputExtra, input)
        ContextCompat.startForegroundService(this, myServiceIntent)
    }

    public fun stopService() {
        val serviceIntent = Intent(this, MyForegroundService::class.java)
        stopService(serviceIntent)
    }

    @Composable
    fun Test(name: String, modifier: Modifier = Modifier) {
    }

}