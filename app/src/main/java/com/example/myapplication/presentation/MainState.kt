package com.example.myapplication.presentation

data class MainState(
    val name: String,
    val lastName: String,
    val friendCount: Int,
    val count: Int = 0,
)
