package com.abel.jetpackprojeto.ApiService

import retrofit2.http.GET

interface  ApiService {

    @GET("users")
    suspend fun  getUsers(): List <User>
    
}