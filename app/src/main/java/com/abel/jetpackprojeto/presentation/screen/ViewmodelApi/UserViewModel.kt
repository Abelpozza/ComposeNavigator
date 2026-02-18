package com.abel.jetpackprojeto.presentation.screen.ViewmodelApi

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abel.jetpackprojeto.data.model.Post
import com.abel.jetpackprojeto.data.remote.ApiService
import com.abel.jetpackprojeto.data.remote.RetrofitInstance
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    var posts = mutableStateOf<List<Post>>(emptyList())
        private set

    var isLoading = mutableStateOf(false)
        private set

    fun loadPosts() {
        viewModelScope.launch {
            isLoading.value = true
            try {
                val response = ApiService().fetchUsers()
                posts.value = response
            } catch (e: Exception) {
                e.printStackTrace()
            }
            isLoading.value = false
        }
    }
}
