package com.example.myapplication

import android.content.Context
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker(context: Context, params: WorkerParameters) : Worker(context, params) {
    override fun doWork(): Result {
        try {
            //Ваш код
        } catch (ex: Exception) {
            return Result.failure()
        }
        return Result.success()
    }
}

fun start(context: Context) {
    val myWorkRequest1 = OneTimeWorkRequestBuilder<MyWorker>().build()
    val myWorkRequest2 = OneTimeWorkRequestBuilder<MyWorker>().build()
    val myWorkRequest3 = OneTimeWorkRequestBuilder<MyWorker>().build()

    WorkManager.getInstance(context)
        .beginWith(myWorkRequest1)
        .then(myWorkRequest2)
        .then(myWorkRequest3)
        .enqueue()
}
