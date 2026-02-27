package com.abel.jetpackprojeto.presentation.screen.ViewmodelApi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abel.jetpackprojeto.data.model.Post
import com.abel.jetpackprojeto.data.remote.ApiClient
import com.abel.jetpackprojeto.presentation.state.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {

    private val _uiState =
        MutableStateFlow<UiState<List<Post>>>(UiState.Loading)

    val uiState: StateFlow<UiState<List<Post>>> = _uiState

    fun loadPostsByUser(userId: Int) {

        viewModelScope.launch {

            _uiState.value = UiState.Loading

            try {
                val posts =
                    ApiClient.api.getPostsByUser(userId)

                _uiState.value = UiState.Success(posts)

            } catch (e: Exception) {
                _uiState.value =
                    UiState.Error("Erro ao carregar posts")
            }
        }
    }
}