package com.example.myapplication.data

import com.example.myapplication.data.model.FriendsCountResponse
import com.example.myapplication.data.model.ProfileResponse

fun getProfileMock(): ProfileResponse = ProfileResponse(
    name = "Иван",
    lastName = "Иванов"
)

fun getFriendCountMock(): FriendsCountResponse = FriendsCountResponse(
    count = 4
)
