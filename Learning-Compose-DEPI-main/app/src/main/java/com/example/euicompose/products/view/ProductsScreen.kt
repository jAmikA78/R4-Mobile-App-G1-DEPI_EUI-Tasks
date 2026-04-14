package com.example.euicompose.products.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import com.example.euicompose.common.UiState
import com.example.euicompose.dto.Product
import com.example.euicompose.products.viewmodel.ProductsViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun ProductsScreen(
    viewModel: ProductsViewModel,
    modifier: Modifier = Modifier
) {
    val uiState: UiState<List<Product>> by viewModel.uiState.collectAsStateWithLifecycle()
    val scope = rememberCoroutineScope()

    /*
    * call API just one time
    * lifecycle aware
    * */
    /*LaunchedEffect(Unit) {
        viewModel.getProductsFromAPI()
    }*/

    when (uiState) {
        is UiState.Loading -> LoadingScreen(modifier)

        is UiState.Success<*> -> SuccessScreen((uiState as UiState.Success<List<Product>>).data, modifier)

        is UiState.Error -> ErrorScreen((uiState as UiState.Error), viewModel, scope, modifier)
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun SuccessScreen(
    productsList: List<Product>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(productsList) { product ->
            ProductItem(product)
        }
    }
}

@Composable
fun ProductItem(
    product: Product,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            AsyncImage(
                model = product.thumbnail,
                contentDescription = product.title,
                modifier = Modifier
                    .width(96.dp)
                    .height(96.dp)
                    .padding(8.dp)
            )

            Column(
                modifier = Modifier.padding(start = 16.dp)
            ) {
                Text(
                    text = "Name: ${product.title ?: "No Title"}",
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    text = "Brand: ${product.brand ?: "Not Categorized"}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}


@Composable
fun ErrorScreen(
    uiStateError: UiState.Error,
    viewModel: ProductsViewModel,
    scope: CoroutineScope,
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Error: ${uiStateError.message}",
            color = Color.Red
        )

        Snackbar(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(64.dp),
            action = {
                Button(
                    onClick = {
                        scope.launch {
                            viewModel.retryFetchProducts()
                        }
                    }
                ) {
                    Text(text = "Retry!")
                }
            }
        ) {
            Text(text = "Failed to load Products! ${uiStateError.message}")
        }
    }
}