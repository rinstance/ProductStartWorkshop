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

fun getImageUrlMock(): String = "https://sun9-5.userapi.com/impg/56s9ihaqBKcEuhlkJdeRSra4MyKU8mkzSg2_KQ/WsukJEiAT0U.jpg?size=700x670&quality=95&sign=9850bb90ec203527972afdc352b4cc10&type=album"
