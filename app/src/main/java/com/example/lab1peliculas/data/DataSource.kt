package com.example.lab1peliculas.data

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class DataSource() {
    private val initialMovieList = movieList()
    private val moviesLiveData = MutableLiveData(initialMovieList)

    fun getMoviesForId(id: Long): Movie? {
        moviesLiveData.value?.let { movies ->
            return movies.firstOrNull{it.id == id}
        }
        return null
    }

    fun getMoviesList(): ArrayList<Movie>{
        return initialMovieList
    }


}