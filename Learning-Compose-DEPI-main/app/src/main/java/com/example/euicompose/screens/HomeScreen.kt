package com.example.euicompose.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(modifier: Modifier = Modifier, onNavigateButtonClicked: (Routes.Profile) -> Unit) {

    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        val userId = 100
        val username = "Ahmed"

        Button(
            onClick = {
                Toast.makeText(context, "Navigate to Profile", Toast.LENGTH_SHORT).show()
                // Navigate to another screen
                // Routes.Profile -> Unit
                // navController.navigate(Routes.Profile(userId, username))
                onNavigateButtonClicked(Routes.Profile(userId, username))
            }
        ) {
            Text(text = "Go to Profile")
        }
    }
}