package com.example.kotlin_movie_app

import android.view.View
import com.example.kotlin_movie_app.model.Movie
import com.example.kotlin_movie_app.util.NullObject

class MoviesPresenter {

    private val NULL_VIEW = NullObject.create(View::class.java)
    private var view = NULL_VIEW

    interface MoviesView {

        fun displayMovies(moviesList: List<Movie>)

    }

}
