package com.example.myapplication.data

import com.example.myapplication.data.model.FriendsCountResponse
import com.example.myapplication.data.model.ProfileResponse

class ProfileRepository {
    suspend fun getProfile(): ProfileResponse = getProfileMock()

    suspend fun getFriendsCount(): FriendsCountResponse = getFriendCountMock()
}