package com.example.euicompose.products.repo

import com.example.euicompose.common.UiState
import com.example.euicompose.dto.Product
import com.example.euicompose.network.RemoteDataSource

class ProductsRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
): ProductsRepository {

    /*
    * primary constructor
    * setter method --> Hide for dependency
    * */

    /*
    * Remote Data Source (HTTPUrlConnection - Volley - Retrofit)
    * Local Data Source (SQLite - Realm - Room)
    * Mocking Data Source
    * */

    /*
    * Don't depend on CONCRETE type, ALWAYS depend on ABSTRACT type
    * Don't HIDE dependency
    * */

    override suspend fun getProductsFromAPI(): UiState<List<Product>> {
        return remoteDataSource.getProducts()
    }
}