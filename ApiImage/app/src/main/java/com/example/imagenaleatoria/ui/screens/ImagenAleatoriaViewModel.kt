package com.example.imagenaleatoria.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imagenaleatoria.model.ImagenAleatoria
import com.example.imagenaleatoria.network.MyApi
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface UiState {
    data class Success(val images: List<ImagenAleatoria>) : UiState
    object Error : UiState
    object Loading : UiState
}

class MarsViewModel : ViewModel() {
    var uiState: UiState by mutableStateOf(UiState.Loading)
        private set

    init {
        getImages()
    }

    fun getImages() {
        viewModelScope.launch {
            uiState = UiState.Loading
            uiState = try {
                // Llamamos a TU api
                val listResult = MyApi.retrofitService.getImages()
                UiState.Success(listResult)
            } catch (e: IOException) {
                UiState.Error
            } catch (e: HttpException) {
                UiState.Error
            }
        }
    }
}