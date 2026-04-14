package com.example.euicompose.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SimpleAnimatedList(modifier: Modifier = Modifier) {
    var items by remember { mutableStateOf(listOf("Apple", "Banana", "Cherry")) }

    LazyColumn(modifier = modifier) {
        items(items) { item ->
            var visible by remember { mutableStateOf(true) }

            AnimatedVisibility(
                visible = visible,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                Text(
                    text = item,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clickable {
                            // Hide item when clicked
                            visible = false
                        }
                )
            }
        }
    }
}