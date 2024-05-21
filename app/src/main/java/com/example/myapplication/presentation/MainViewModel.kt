package com.example.myapplication.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.GetFriendCountInteractor
import com.example.myapplication.domain.GetImageUrlInteractor
import com.example.myapplication.domain.GetProfileInteractor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val getFriendCountInteractor = GetFriendCountInteractor()
    private val getProfileInteractor = GetProfileInteractor()
    private val getImageUrlInteractor = GetImageUrlInteractor()

    private val _state = MutableStateFlow<MainState?>(null)
    val state: StateFlow<MainState?> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            val profile = getProfileInteractor.getProfile()
            val friends = getFriendCountInteractor.getFriendsCount()
            val image = getImageUrlInteractor.getImageUrl()

            _state.value = MainState(
                name = profile.name,
                lastName = profile.lastName,
                friendsCount = friends.count,
                image = image
            )
        }
    }

}
