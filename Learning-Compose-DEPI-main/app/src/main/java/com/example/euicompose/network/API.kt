package com.example.euicompose.network

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object API {

    private val gson = GsonBuilder().serializeNulls().create()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://dummyjson.com/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    val apiService: APIService by lazy {
        retrofit.create(APIService::class.java)
    }
}