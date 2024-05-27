package com.example.myapplication.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.GetFriendCountInteractor
import com.example.myapplication.domain.GetProfileInteractor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val getFriendCountInteractor = GetFriendCountInteractor()
    private val getProfileInteractor = GetProfileInteractor()

    private val _state = MutableStateFlow<MainState?>(null)
    val state: StateFlow<MainState?> = _state.asStateFlow()

    fun incCount() {
        _state.value = state.value?.copy(
            count = (state.value?.count ?: 0) + 1
        )
    }

    init {
        viewModelScope.launch {
            val profile = getProfileInteractor.getProfile()
            val friends = getFriendCountInteractor.getFriendsCount()

            _state.value = MainState(
                name = profile.name,
                lastName = profile.lastName,
                friendCount = friends.count
            )
        }
    }

}
