package com.example.euicompose.products.repo

import com.example.euicompose.common.UiState
import com.example.euicompose.dto.Product

interface ProductsRepository {

    suspend fun getProductsFromAPI(): UiState<List<Product>>
}