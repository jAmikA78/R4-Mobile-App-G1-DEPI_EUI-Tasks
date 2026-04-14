package com.example.euicompose.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import com.example.euicompose.settings.Settings

val Context.settingsDataStore: DataStore<Settings> by dataStore(
    fileName = "settings.pb",
    serializer = SettingsSerializer
)