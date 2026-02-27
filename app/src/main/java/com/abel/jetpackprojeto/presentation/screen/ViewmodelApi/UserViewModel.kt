package com.abel.jetpackprojeto.presentation.screen.ViewmodelApi


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abel.jetpackprojeto.data.model.User
import com.abel.jetpackprojeto.data.remote.ApiClient
import com.abel.jetpackprojeto.presentation.state.UiState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    private val _uiState =
        MutableStateFlow<UiState<List<User>>>(UiState.Loading)

    val uiState: StateFlow<UiState<List<User>>> = _uiState

    fun loadUsers() {
        viewModelScope.launch {

            _uiState.value = UiState.Loading

            try {
                val users = ApiClient.api.getUsers()
                _uiState.value = UiState.Success(users)

            } catch (e: Exception) {
                _uiState.value =
                    UiState.Error("Erro ao carregar usuários")
            }
        }
    }
}




