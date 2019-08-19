package com.example.kotlin_movie_app

import android.os.Bundle
import androidx.fragment.app.FragmentActivity

/**
 * Loads [MovieBrowseFragment]
 */

class MoviesActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MovieApplication.instance().appComponent.inject(this)
        setContentView(R.layout.activity_movies)
    }



}