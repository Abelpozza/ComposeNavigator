package com.abel.jetpackprojeto.data.remote

import com.abel.jetpackprojeto.data.model.Post
import com.abel.jetpackprojeto.data.model.User
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query



interface ApiService {

    @GET("users")
    suspend fun fetchUser(): List<User>

    @GET("users")
    suspend fun getUsers(): List<User>

    @GET("posts")
    suspend fun fetchPosts(): List<Post>

    @GET("posts")
    suspend fun getPostsByUser(
        @Query("userId") userId: Int
    ): List<Post>

    @GET("posts/{id}")
    suspend fun fetchPostById(
        @Path("id") postId: Int
    ): Post
}