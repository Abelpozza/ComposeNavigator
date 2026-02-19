package com.abel.jetpackprojeto.presentation.screen.ViewmodelApi

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abel.jetpackprojeto.data.model.Post
import com.abel.jetpackprojeto.data.model.User
import com.abel.jetpackprojeto.data.remote.ApiService
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    var users = mutableStateOf<List<User>>(emptyList())
        private set

    var posts = mutableStateOf<List<Post>>(emptyList())
        private set

    var isLoading = mutableStateOf(false)
        private set

    fun loadUsers() {
        viewModelScope.launch {
            isLoading.value = true
            try {
                val response = ApiService().fetchUser()
                users.value = response
            } catch (e: Exception) {
                e.printStackTrace()
            }
            isLoading.value = false
        }
    }

    fun loadPostsByUser(userId: Int) {
        viewModelScope.launch {
            isLoading.value = true
            try {
                val response = ApiService().fetchPosts()
                posts.value = response.filter { post ->
                    post.userId == userId
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            isLoading.value = false
        }
    }
        }

