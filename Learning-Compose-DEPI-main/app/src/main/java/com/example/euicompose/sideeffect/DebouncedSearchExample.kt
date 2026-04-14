package com.example.euicompose.sideeffect

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter

@OptIn(FlowPreview::class)
@Composable
fun DebouncedSearchExample(modifier: Modifier = Modifier) {
    var query by remember { mutableStateOf("") }
    var results by remember { mutableStateOf("") }

    /*
    * wait 2 seconds before hitting the API (after user typing)
    * ignore empty text
    * ignore repeated value
    * */
    LaunchedEffect(Unit) {
        snapshotFlow { query }
            .debounce(2000) // wait 2 seconds before hitting the API (after user typing)
            .filter { it.isNotEmpty() } // ignore empty text
            .distinctUntilChanged() // ignore repeated value
            .collectLatest { searchText ->
                results = "Searching for: \"$searchText\"..."
                delay(2000) // simulate Network call
                results = "Results for: \"$searchText\" Completed ✅"
            }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = query,
            onValueChange = { query = it },
            label = { Text("Search Movies") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(16.dp))
        Text(results, style = MaterialTheme.typography.bodyLarge)
    }
}