package com.example.myapplication.domain

import com.example.myapplication.data.ProfileRepository
import com.example.myapplication.domain.model.ProfileData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetProfileInteractor {

    private val profileRepository: ProfileRepository = ProfileRepository()

    suspend fun getProfile(): ProfileData = withContext(Dispatchers.IO) {
        val profile = profileRepository.getProfile()

        ProfileData(
            name = profile.name,
            lastName = profile.lastName
        )
    }

}