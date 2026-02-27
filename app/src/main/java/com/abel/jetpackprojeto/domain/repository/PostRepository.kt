package com.abel.jetpackprojeto.data.repository

import com.abel.jetpackprojeto.data.remote.RetrofitInstance

class PostRepository {

    suspend fun getPosts() =
        RetrofitInstance.api.fetchPosts()

    suspend fun getUsers() =
        RetrofitInstance.api.fetchUser()
}