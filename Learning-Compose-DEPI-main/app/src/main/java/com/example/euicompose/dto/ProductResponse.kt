package com.example.euicompose.dto

data class ProductResponse(
    val limit: Int?,
    val products: List<Product>?,
    val skip: Int?,
    val total: Int?
)