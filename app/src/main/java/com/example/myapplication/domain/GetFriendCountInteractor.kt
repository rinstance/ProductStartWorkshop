package com.example.myapplication.domain

import com.example.myapplication.data.ProfileRepository
import com.example.myapplication.domain.model.FriendsCountData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetFriendCountInteractor {

    private val profileRepository: ProfileRepository = ProfileRepository()

    suspend fun getFriendsCount(): FriendsCountData = withContext(Dispatchers.IO) {
        val data = profileRepository.getFriendsCount()

        FriendsCountData(count = data.count)
    }

}