package com.example.euicompose.products.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.euicompose.common.UiState
import com.example.euicompose.dto.Product
import com.example.euicompose.products.repo.ProductsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductsViewModel(
    private val repo: ProductsRepository
): ViewModel() {

    /*
    * Don't (NEVER EVER) depend on CONCRETE type
    * ALWAYS depend on ABSTRACT type (abstract class & interface)
    *
    * Don't HIDE dependency
    * */

    private val _uiState = MutableStateFlow<UiState<List<Product>>>(UiState.Loading)
    val uiState: StateFlow<UiState<List<Product>>> = _uiState

    init {
        getProductsFromAPI()
    }

    private fun getProductsFromAPI() {
        // loading
        _uiState.value = UiState.Loading

        // success / error
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.emit(repo.getProductsFromAPI())
        }
    }

    fun retryFetchProducts() {
        getProductsFromAPI()
    }
}