package com.example.euicompose.datastore

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.example.euicompose.settings.Settings
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

object SettingsSerializer: Serializer<Settings> {

    override val defaultValue: Settings = Settings.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): Settings =
        try {
            Settings.parseFrom(input)
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            throw CorruptionException("Cannot read proto.", ioException)
        }

    override suspend fun writeTo(
        t: Settings,
        output: OutputStream
    ) {
        t.writeTo(output)
    }
}