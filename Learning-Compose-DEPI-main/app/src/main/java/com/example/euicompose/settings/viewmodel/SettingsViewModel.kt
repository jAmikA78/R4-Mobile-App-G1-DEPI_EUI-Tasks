package com.example.euicompose.settings.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.euicompose.common.UiState
import com.example.euicompose.dto.Product
import com.example.euicompose.settings.Settings
import com.example.euicompose.settings.repo.SettingsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class SettingsViewModel(
    private val repository: SettingsRepository
) : ViewModel() {

    /*val userNameFlow = repository.userNameFlow.stateIn(viewModelScope, SharingStarted.Lazily, "Loading...")
    val userAgeFlow = repository.userAgeFlow.stateIn(viewModelScope, SharingStarted.Lazily, 0)
    val userTokenFlow = repository.userTokenFlow.stateIn(viewModelScope, SharingStarted.Lazily, null)
    val languageFlow = repository.languageFlow.stateIn(viewModelScope, SharingStarted.Lazily, "EN")
    val darkModeFlow = repository.darkModeFlow.stateIn(viewModelScope, SharingStarted.Lazily, false)
    val notificationsFlow = repository.notificationsFlow.stateIn(viewModelScope, SharingStarted.Lazily, true)*/
    private val _darkModeFlow = MutableStateFlow(false)
    val darkModeFlow: StateFlow<Boolean> = _darkModeFlow

    private val _notificationsFlow = MutableStateFlow(false)
    val notificationsFlow: StateFlow<Boolean> = _notificationsFlow

    private val _languageFlow = MutableStateFlow("")
    val languageFlow: StateFlow<String> = _languageFlow

    private val _userNameFlow = MutableStateFlow("Guest")
    val userNameFlow: StateFlow<String> = _userNameFlow

    val settingsFlow = repository.settings.stateIn(viewModelScope, SharingStarted.Lazily, Settings.getDefaultInstance())

    fun setUserName(userName: String) = viewModelScope.launch {
        repository.saveUserName(userName)
    }

    fun setUserAge(userAge: Int) = viewModelScope.launch {
        repository.saveUserAge(userAge)
    }

    fun setUserToken(userToken: String) = viewModelScope.launch {
        repository.saveUserToken(userToken)
    }

    fun setLanguage(language: String) = viewModelScope.launch {
        repository.saveLanguage(language)
    }

    fun setDarkMode(darkMode: Boolean) = viewModelScope.launch {
        repository.saveDarkMode(darkMode)
    }

    fun setNotifications(notifications: Boolean) = viewModelScope.launch {
        repository.saveNotifications(notifications)
    }

    /*fun setDarkMode(darkMode: Boolean) = viewModelScope.launch {
        _darkModeFlow.value = darkMode
    }*/

    fun saveSettings(settings: Settings) = viewModelScope.launch {
        repository.saveSettings(settings)
    }
}