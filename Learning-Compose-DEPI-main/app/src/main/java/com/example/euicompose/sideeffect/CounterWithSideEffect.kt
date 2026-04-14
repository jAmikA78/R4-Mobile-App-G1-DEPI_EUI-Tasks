package com.example.euicompose.sideeffect

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun CounterWithSideEffect() {
    var count by remember { mutableIntStateOf(0) }

    // Runs after every recomposition (i.e., every time `count` changes)
    SideEffect {
        println("asd --> SideEffect triggered! Current count = $count")
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Count: $count")

        Button(onClick = {
            count++
            println("asd --> Button clicked!")

        }) {
            Text("Increase")
        }
    }
}