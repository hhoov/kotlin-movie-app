package com.example.kotlin_movie_app.ui

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.kotlin_movie_app.MovieApplication
import com.example.kotlin_movie_app.R

/**
 * Loads [MovieBrowseFragment]
 */
class MoviesActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)
        MovieApplication.instance().appComponent.inject(this)
    }
}