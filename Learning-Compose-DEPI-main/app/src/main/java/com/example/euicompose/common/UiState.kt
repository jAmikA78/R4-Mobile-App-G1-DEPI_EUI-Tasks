package com.example.euicompose.common

sealed class UiState<out T> {
    /*
    * Loading...
    * Success --> ProductResponse
    * Failure --> Error or Exception or delay (outage)
    * */
    object Loading: UiState<Nothing>()
    data class Success<T>(val data: T): UiState<T>()
    data class Error(val message: String): UiState<Nothing>()
}