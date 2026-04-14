package com.example.euicompose.network

import com.example.euicompose.dto.ProductResponse
import retrofit2.Response
import retrofit2.http.GET

interface APIService {

    @GET("products")
    suspend fun getProducts(): Response<ProductResponse>
}