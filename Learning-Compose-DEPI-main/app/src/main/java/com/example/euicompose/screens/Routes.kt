package com.example.euicompose.screens

import kotlinx.serialization.Serializable

sealed interface Routes {

    @Serializable
    object Home: Routes

    @Serializable
    data class Profile(val userId: Int, val username: String): Routes
}