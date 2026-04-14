package com.example.euicompose.sideeffect

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner

@Composable
fun AnimatedLifecycleScreen(modifier: Modifier = Modifier) {
    val lifecycleOwner = LocalLifecycleOwner.current
    val visibleState = remember { MutableTransitionState(false) }

    LaunchedEffect(Unit) {
        visibleState.targetState = true
    }

    // Observe lifecycle and clean up properly
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            println("Lifecycle event -> $event")
            if (event == Lifecycle.Event.ON_PAUSE) {
                visibleState.targetState = false // hide when backgrounded
            } else if (event == Lifecycle.Event.ON_RESUME) {
                visibleState.targetState = true // re-show when resumed
            } else if (event == Lifecycle.Event.ON_DESTROY) {
                // Dismiss / Cancel the current job
            }
        }

        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            println("DisposableEffect -> Cleaning up observer")
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    // Animated content
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimatedVisibility(
            visibleState = visibleState,
            enter = fadeIn() + scaleIn(),
            exit = fadeOut() + scaleOut()
        ) {
            Text(
                text = "Hello Compose!",
                style = MaterialTheme.typography.headlineMedium
            )
        }

        Button(onClick = { visibleState.targetState = !visibleState.targetState }) {
            Text(if (visibleState.targetState) "Hide" else "Show")
        }
    }
}