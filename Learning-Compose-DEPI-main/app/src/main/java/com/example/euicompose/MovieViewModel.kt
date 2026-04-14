package com.example.euicompose

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MovieViewModel: ViewModel() {

    private val _movieList = MutableStateFlow(value = emptyList<String>())
    val movieList = _movieList.asStateFlow()

    private val _movieList2 = MutableStateFlow(value = emptyList<String>())
    val movieList2 = _movieList2.asStateFlow()

    fun getPopularMovies1() {
        _movieList.value = mutableListOf(
            "Spider man",
            "Spider man2",
            "Spider man3",
            "Superman",
            "Batman",
            "Spider man",
            "Spider man2",
            "Spider man3",
            "Superman",
            "Batman",
            "Spider man",
            "Spider man2",
            "Spider man3",
            "Superman",
            "Batman",
            "Spider man",
            "Spider man2",
            "Spider man3",
            "Superman",
            "Batman",
        )
    }

    fun getPopularMovies2() {
        _movieList2.value = mutableListOf(
            "El3aref",
            "Zaki shan",
            "White and Black",
            "My dad on the tree",
            "Noor 3iny",
            "Ba7bk",
            "El3aref",
            "Zaki shan",
            "White and Black",
            "My dad on the tree",
            "Noor 3iny",
            "Ba7bk",
            "El3aref",
            "Zaki shan",
            "White and Black",
            "My dad on the tree",
            "Noor 3iny",
            "Ba7bk",
        )
    }
}