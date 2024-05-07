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

    private val _name = MutableStateFlow<String?>(null)
    val name: StateFlow<String?> = _name.asStateFlow()

    private val _lastName = MutableStateFlow<String?>(null)
    val lastName: StateFlow<String?> = _lastName.asStateFlow()

    private val _count = MutableStateFlow<Int?>(null)
    val count: StateFlow<Int?> = _count.asStateFlow()

    private val _state = MutableStateFlow<MainState?>(null)
    val state: StateFlow<MainState?> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            val profile = getProfileInteractor.getProfile()
            val friends = getFriendCountInteractor.getFriendsCount()

            _name.value = profile.name
            _lastName.value = profile.lastName
//
            _count.value = friends.count

//            _state.value = MainState(
//                name = profile.name,
//                lastName = profile.lastName,
//                count = friends.count
//            )
        }
    }

}
