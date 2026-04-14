package com.example.euicompose.sideeffect

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun LaunchedEffectDemo(modifier: Modifier = Modifier) {

    var name by remember { mutableStateOf("Ahmed") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Current name: $name", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                name = if (name == "Ahmed") "Malek" else "Ahmed"
            }
        ) { Text("Change Name") }

        LaunchedEffect(name) {
            println("asd --> LaunchedEffect: triggered name = $name")
            delay(2000)
            println("asd --> Task finished for name = $name")
        }
    }
}