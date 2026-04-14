package com.example.euicompose.components

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DismissDirection
import androidx.compose.material.DismissValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.rememberDismissState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SimpleSwipeToDismissBox(
    context: Context,
    modifier: Modifier = Modifier
) {
    var boxVisibility by remember { mutableStateOf(true) }
    val dismissState = rememberDismissState(
        confirmStateChange = { value ->
            when (value) {
                DismissValue.DismissedToStart,
                DismissValue.DismissedToEnd -> {
                    Toast.makeText(context, "Item dismissed!", Toast.LENGTH_SHORT).show()
                    boxVisibility = false
                    true // confirm the dismissal
                }
                else -> {
                    boxVisibility = true
                    false
                }
            }
        }
    )

    SwipeToDismiss(
        modifier = modifier,
        state = dismissState,
        background = {
            if (boxVisibility) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Red),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Text(
                        "Deleting...",
                        color = Color.White,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        },
        dismissContent = {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Text(
                    text = "Swipe me left or right",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    )
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SimpleSwipeToDismissBox(modifier: Modifier = Modifier) {
    val dismissState = rememberDismissState(
        confirmStateChange = { dismissedValue ->
            when (dismissedValue) {
                DismissValue.DismissedToStart,
                DismissValue.DismissedToEnd -> true
                else -> false
            }
        }
    )
    val boxVisibility by remember { derivedStateOf { dismissState.isDismissed(DismissDirection.StartToEnd).not() || dismissState.isDismissed(DismissDirection.EndToStart).not() } }

    SwipeToDismiss(
        modifier = modifier,
        state = dismissState,
        background = {
            if (boxVisibility) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Red),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Text("Deleting...", color = Color.White, modifier = Modifier.padding(16.dp))
                }
            }
        },
        dismissContent = {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Text(
                    text = "Swipe me left or right",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    )
}