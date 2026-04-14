package com.example.euicompose.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun ProfileScreen(profile: Routes.Profile, modifier: Modifier = Modifier, onBackClicked: () -> Unit) {

    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Gray)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "This is the Profile Screen")

        Spacer(Modifier.height(16.dp))

        Text(text = "UserId = ${profile.userId}")
        Text(text = "username = ${profile.username}")

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = {
                Toast.makeText(context, "Back", Toast.LENGTH_SHORT).show()
                // Navigate back (pop off from back stack)
                // () -> Unit
                // navController.popBackStack()
                onBackClicked()
            }
        ) {
            Text(text = "Back")
        }
    }
}