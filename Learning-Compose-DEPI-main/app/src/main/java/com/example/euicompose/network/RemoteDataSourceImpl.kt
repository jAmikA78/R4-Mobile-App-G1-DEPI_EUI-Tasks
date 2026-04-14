package com.example.euicompose.network

import com.example.euicompose.common.UiState
import com.example.euicompose.dto.Product
import com.example.euicompose.network.API.apiService

class RemoteDataSourceImpl: RemoteDataSource {

    override suspend fun getProducts(): UiState<List<Product>> {
        return try {
            val response = apiService.getProducts()

            if (response.isSuccessful) {
                val productsList = response.body()?.products ?: emptyList()

                UiState.Success(productsList)
            } else {
                /*
                * 300... --> Redirection --> Bad Request
                * 400... --> Client Error
                * 500... --> Server Error
                * */
                when (response.code()) {
                    in 300..399 -> UiState.Error("Redirection - Bad Request: ${response.code()} - ${response.message()}")
                    in 400..499 -> UiState.Error("Client Error: ${response.code()} - ${response.message()}")
                    in 500..599 -> UiState.Error("Server Error: ${response.code()} - ${response.message()}")
                    else -> UiState.Error("Error: ${response.code()} - ${response.message()}")
                }

            }
        } catch (exception: Exception){
            UiState.Error("Exception: ${exception.localizedMessage ?: "Unknown Error!"}")
        }
    }
}