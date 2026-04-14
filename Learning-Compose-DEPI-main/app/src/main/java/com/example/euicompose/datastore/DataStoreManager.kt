package com.example.euicompose.datastore

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore("settings")

class DataStoreManager(private val context: Context) {

    companion object {
        private val USER_NAME_KEY = stringPreferencesKey("user_name")
        private val USER_AGE_KEY = intPreferencesKey("user_age")
        private val USER_TOKEN_KEY = stringPreferencesKey("user_token")
        private val LANGUAGE_KEY = stringPreferencesKey("language")
        private val DARK_MODE_KEY = booleanPreferencesKey("dark_mode")
        private val NOTIFICATIONS_KEY = booleanPreferencesKey("notifications")
    }

    suspend fun saveUserName(userName: String) {
        context.dataStore.edit { preferences ->
            preferences[USER_NAME_KEY] = userName
        }
    }
    val userNameFlow: Flow<String> = context.dataStore.data.map { preferences ->
        preferences[USER_NAME_KEY] ?: "Guest"
    }

    suspend fun saveUserAge(userAge: Int) {
        context.dataStore.edit { preferences ->
            preferences[USER_AGE_KEY] = userAge
        }
    }
    val userAgeFlow: Flow<Int> = context.dataStore.data.map { preferences ->
        preferences[USER_AGE_KEY] ?: 0
    }

    suspend fun saveUserToken(userToken: String) {
        context.dataStore.edit { preferences ->
            preferences[USER_TOKEN_KEY] = userToken
        }
    }
    val userTokenFlow: Flow<String?> = context.dataStore.data.map { preferences ->
        preferences[USER_TOKEN_KEY]
    }

    suspend fun saveLanguage(language: String) {
        context.dataStore.edit { preferences ->
            preferences[LANGUAGE_KEY] = language
        }
    }
    val languageFlow = context.dataStore.data.map { preferences ->
        preferences[LANGUAGE_KEY] ?: "EN" // check system language & check that it was defined in your localization --> if exists, use it. Otherwise; choose a default language
    }

    suspend fun saveDarkMode(darkMode: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[DARK_MODE_KEY] = darkMode
        }
    }
    val darkModeFlow = context.dataStore.data.map { preferences ->
        preferences[DARK_MODE_KEY] ?: false // check system dark mode
    }

    suspend fun saveNotifications(notifications: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[NOTIFICATIONS_KEY] = notifications
        }
    }
    val notificationsFlow = context.dataStore.data.map { preferences ->
        preferences[NOTIFICATIONS_KEY] ?: true
    }
}