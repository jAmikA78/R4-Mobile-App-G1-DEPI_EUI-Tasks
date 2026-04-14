package com.example.euicompose.sideeffect

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DerivedStateExample() {
    var counter by remember { mutableIntStateOf(0) }

    // derivedStateOf recalculates only when `counter` changes
    val isEven by remember { derivedStateOf { counter % 2 == 0 } }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            println("asd --> Recomposing DerivedStateExample")

            CounterText(counter)

            Spacer(Modifier.height(8.dp))

            EvenText(isEven)

            Spacer(Modifier.height(16.dp))

            Button(onClick = {
//                counter++
                counter += 2
            }) {
                Text("Increment")
            }
        }
    }
}

@Composable
fun CounterText(counter: Int) {
    println("asd --> CounterText recomposed")
    Text("Counter: $counter", style = MaterialTheme.typography.titleLarge)
}

@Composable
fun EvenText(isEven: Boolean) {
    println("asd --> EvenText recomposed")
    Text("Is Even: $isEven")
}