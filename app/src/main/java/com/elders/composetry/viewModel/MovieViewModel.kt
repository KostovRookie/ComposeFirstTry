package com.elders.composetry.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elders.composetry.data.Movie
import com.elders.composetry.network.ApiService
import kotlinx.coroutines.launch

class MovieViewModel: ViewModel() {
    var movieListResponse: List<Movie> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")

    fun getMovieList() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val movieList = apiService.getMovies()
                movieListResponse = movieList
            }
            catch (e:Exception) {
                errorMessage = e.message.toString()
            }
        }
    }


}