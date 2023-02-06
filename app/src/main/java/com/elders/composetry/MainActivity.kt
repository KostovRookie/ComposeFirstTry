package com.elders.composetry

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.elders.composetry.data.Movie
import com.elders.composetry.ui.theme.ComposeTryTheme
import com.elders.composetry.view.MovieItem
import com.elders.composetry.viewModel.MovieViewModel

class MainActivity : ComponentActivity() {


    private val movieViewModel by viewModels<MovieViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTryTheme {
                Surface(color = MaterialTheme.colors.background) {
                    MovieList(movieList = movieViewModel.movieListResponse)
                    movieViewModel.getMovieList()
                    
                }
                    

                
            }

        }
    }
}


@Composable
fun MovieList(movieList: List<Movie>) {
    LazyColumn {
        itemsIndexed(items = movieList) { _, item ->
            MovieItem(movie = item)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    ComposeTryTheme {
        val movie = Movie("Developer's Say", "", desc = "Hi guys, this is description","category text")
        MovieItem(movie = movie)
    }
}

