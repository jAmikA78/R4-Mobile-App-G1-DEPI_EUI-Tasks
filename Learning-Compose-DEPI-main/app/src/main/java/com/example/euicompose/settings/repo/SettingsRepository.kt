package com.example.euicompose.settings.repo

import com.example.euicompose.settings.Settings
import kotlinx.coroutines.flow.Flow

interface SettingsRepository {

    suspend fun saveUserName(userName: String)
    val userNameFlow: Flow<String>

    suspend fun saveUserAge(userAge: Int)
    val userAgeFlow: Flow<Int>

    suspend fun saveUserToken(userToken: String)
    val userTokenFlow: Flow<String?>

    suspend fun saveLanguage(language: String)
    val languageFlow: Flow<String>

    suspend fun saveDarkMode(darkMode: Boolean)
    val darkModeFlow: Flow<Boolean>

    suspend fun saveNotifications(notifications: Boolean)
    val notificationsFlow: Flow<Boolean>




    suspend fun saveSettings(settings: Settings): Settings
    val settings: Flow<Settings>
}