package com.farimarwat.bookapp.presentation.state

sealed class UiState<out T> {
    object Empty:UiState<Nothing>()
    object Loading : UiState<Nothing>()
    data class Success<T>(val data: T) : UiState<T>()
    data class Error(val message: String) : UiState<Nothing>()
}
