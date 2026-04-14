package com.example.euicompose.settings.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.euicompose.settings.Settings
import com.example.euicompose.settings.viewmodel.SettingsViewModel

@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel,
    modifier: Modifier = Modifier
) {

    val darkMode by viewModel.darkModeFlow.collectAsStateWithLifecycle()
    val notification by viewModel.notificationsFlow.collectAsStateWithLifecycle()
    val language by viewModel.languageFlow.collectAsStateWithLifecycle()
    val username by viewModel.userNameFlow.collectAsStateWithLifecycle()

    val settings: Settings by viewModel.settingsFlow.collectAsStateWithLifecycle()
    viewModel.saveSettings(settings)

    Column(modifier.padding(16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Dark Mode")
            Switch(
                checked = darkMode,
                onCheckedChange = {
                    viewModel.setDarkMode(it)
                }
            )
        }

        Spacer(Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Notifications")
            Switch(
                checked = notification,
                onCheckedChange = { viewModel.setNotifications(it) }
            )
        }

        Spacer(Modifier.height(16.dp))

        Text("Language: ${language.uppercase()}")
        val languages = listOf("en", "fr", "ar")
        Row {
            languages.forEach { lang ->
                Button(
                    onClick = { viewModel.setLanguage(lang) },
                    modifier = Modifier.padding(end = 8.dp)
                ) {
                    Text(lang.uppercase())
                }
            }
        }

        Spacer(Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Hello, $username")
            Button(onClick = { viewModel.setUserName("Ahmed") }) {
                Text("Update Name")
            }
        }
    }
}