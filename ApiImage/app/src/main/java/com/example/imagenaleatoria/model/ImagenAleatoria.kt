package com.example.imagenaleatoria.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ImagenAleatoria (
    val id: String,
    val name: String,
    @SerialName("avatar") val imageUrl: String
)