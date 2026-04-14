package com.example.euicompose.network

import com.example.euicompose.common.UiState
import com.example.euicompose.dto.Product

interface RemoteDataSource {

    /*
    * Loading...
    * Success --> ProductResponse
    * Failure --> Error or Exception or delay (outage)
    * */
    suspend fun getProducts(): UiState<List<Product>>
}