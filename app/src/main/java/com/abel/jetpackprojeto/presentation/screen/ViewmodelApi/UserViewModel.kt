package com.abel.jetpackprojeto.presentation.screen.ViewmodelApi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abel.jetpackprojeto.data.model.Post
import com.abel.jetpackprojeto.data.remote.ApiService
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf


class UserViewModel : ViewModel() {

    private val api = ApiService()

    var post = mutableStateOf<List<Post>>(emptyList())
        private set

    var selectedPost = mutableStateOf<Post?>(null)
        private set

    var isLoading = mutableStateOf(false)
        private set

    fun loadPosts() {
        viewModelScope.launch {
            isLoading.value = true
            try {
                post.value = api.fetchUsers()
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                isLoading.value = false
            }
        }
    }
    fun loadPostById(id: Int) {
        viewModelScope.launch {
            isLoading.value = true
            try {
                selectedPost.value = api.fetchPostById(id)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                isLoading.value = false
            }
        }
    }
}
