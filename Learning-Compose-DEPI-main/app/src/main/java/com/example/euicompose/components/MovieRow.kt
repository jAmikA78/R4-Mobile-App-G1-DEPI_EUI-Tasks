package com.example.euicompose.components

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.euicompose.ui.theme.EUIComposeTheme

@Composable
//fun MovieRow(movie: Int) {
fun MovieRow(movie: String) {
    val context = LocalContext.current

    val dismissBoxState = rememberSwipeToDismissBoxState()
    val visibility by remember { derivedStateOf { dismissBoxState.currentValue == SwipeToDismissBoxValue.Settled } }

    if (visibility.not()) {
        // call viewmodel to update the list / DB / ...
    }

    AnimatedVisibility(
        visible = visibility,
        exit = shrinkVertically()
    ) {
        SwipeToDismissBox(
            state = dismissBoxState,
            backgroundContent = {
                if (visibility) {
                    Box(
                        modifier = Modifier
                            .padding(12.dp)
                            .fillMaxWidth()
                            .background(Color.Red)
                    ) {
                        Text(
                            text = "Deleting...",
                            color = Color.White,
                            modifier = Modifier.padding(4.dp)
                        )
                    }
                }
            }
        ) {
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .clickable {
                        // navigate to details screen
                        Toast.makeText(context, movie, Toast.LENGTH_SHORT).show()
                    },
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                Text(
                    text = "Movie Name: $movie",
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MovieRowPreview() {
    EUIComposeTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                MovieRow("TT7")
            }
        }
    }
}