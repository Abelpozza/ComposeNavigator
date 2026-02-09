package com.abel.jetpackprojeto.UserViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.*
import com.abel.jetpackprojeto.User.User
import com.abel.jetpackprojeto.retro_fit_instance.RetroFitInstance

class UserViewModel : viewModel () {

    var usuers by mutableStateOf<List<User>>(emptyList())
        private set

    var loading by mutableStateOf(true)
        private set

    init {
        fetchUsers()
    }
    }


private fun fetchUsers() {
    viewModelScope.launch {
        try {
            users = RetroFitInstance.api.getUsers()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            loading = false

        }
    }
}

