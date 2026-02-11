package com.example.imagenaleatoria.network

import com.example.imagenaleatoria.model.ImagenAleatoria
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL = "https://697ca524889a1aecfeb31c1f.mockapi.io/"

private val json = Json { ignoreUnknownKeys = true }

private val retrofit = Retrofit.Builder()
    .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface ApiService {
    @GET("images")
    suspend fun getImages(): List<ImagenAleatoria>
}

object MyApi {
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}