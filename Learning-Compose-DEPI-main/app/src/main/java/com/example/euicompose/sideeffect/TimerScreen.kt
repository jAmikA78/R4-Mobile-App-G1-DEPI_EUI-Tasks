package com.example.euicompose.sideeffect

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.delay

@SuppressLint("ProduceStateDoesNotAssignValue")
@Composable
fun TimerScreen() {
    var running by remember { mutableStateOf(true) }
    val lifecycleOwner = LocalLifecycleOwner.current

    val time by produceState(initialValue = 0) {
        lifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
            while (true) {
                if (running) {
                    delay(1000)
                    value++   // keeps previous value → resume
                } else {
                    delay(100)
                }
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Seconds passed: $time", style = MaterialTheme.typography.displayMedium)

        Spacer(Modifier.height(16.dp))

        Button(onClick = { running = !running }) {
            Text(if (running) "Pause" else "Resume")
        }
    }
}