package com.example.euicompose

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CounterViewModel: ViewModel() {

    private val _count = MutableStateFlow(0)
    val count: StateFlow<Int> = _count.asStateFlow()

    fun increment() {
        // emit
        _count.value++
    }

    fun decrement() {
        _count.value--
    }

    /*
    * viewmodel --> repo --> [local / remote] data source --> [Room / Retrofit]
    * */
}