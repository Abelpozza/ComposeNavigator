package com.abel.jetpackprojeto.retro_fit_instance

import com.abel.jetpackprojeto.ApiService.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroFitInstance {

    private const val BASE_URL = "https://api.exemplo.com/"
}

val api: ApiService by lazy {
    Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)
}

}