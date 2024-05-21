package com.example.myapplication.domain

import com.example.myapplication.data.ProfileRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class GetImageUrlInteractor {

    private val profileRepository: ProfileRepository = ProfileRepository()

    suspend fun getImageUrl(): String = withContext(Dispatchers.IO) {
        profileRepository.getImageUrl()
    }

}