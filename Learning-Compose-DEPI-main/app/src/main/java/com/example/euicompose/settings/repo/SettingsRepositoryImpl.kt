package com.example.euicompose.settings.repo

import android.content.Context
import androidx.datastore.core.DataStore
import com.example.euicompose.datastore.DataStoreManager
import com.example.euicompose.settings.Settings
import kotlinx.coroutines.flow.Flow

class SettingsRepositoryImpl(
    private val dataStoreManager: DataStoreManager,
    private val settingsDataStoreProto: DataStore<Settings>,
): SettingsRepository {

    override suspend fun saveUserName(userName: String) = dataStoreManager.saveUserName(userName)
    override val userNameFlow: Flow<String> = dataStoreManager.userNameFlow

    override suspend fun saveUserAge(userAge: Int) = dataStoreManager.saveUserAge(userAge)
    override val userAgeFlow: Flow<Int> = dataStoreManager.userAgeFlow

    override suspend fun saveUserToken(userToken: String) = dataStoreManager.saveUserToken(userToken)
    override val userTokenFlow: Flow<String?> = dataStoreManager.userTokenFlow

    override suspend fun saveLanguage(language: String) = dataStoreManager.saveLanguage(language)
    override val languageFlow: Flow<String> = dataStoreManager.languageFlow

    override suspend fun saveDarkMode(darkMode: Boolean) = dataStoreManager.saveDarkMode(darkMode)
    override val darkModeFlow: Flow<Boolean> = dataStoreManager.darkModeFlow

    override suspend fun saveNotifications(notifications: Boolean) = dataStoreManager.saveNotifications(notifications)
    override val notificationsFlow: Flow<Boolean> = dataStoreManager.notificationsFlow





    override suspend fun saveSettings(settings: Settings): Settings = settingsDataStoreProto.updateData { settings ->
        settings.toBuilder()
            .setDarkMode(settings.darkMode)
            .setNotificationsEnabled(settings.notificationsEnabled)
            .setLanguage(settings.language)
            .setUsername(settings.username)
            .build()
    }
    override val settings: Flow<Settings> = settingsDataStoreProto.data
}