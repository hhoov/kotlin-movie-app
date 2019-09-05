package com.example.kotlin_movie_app.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.kotlin_movie_app.MovieApplication
import com.example.kotlin_movie_app.R

class MovieDetailsActivity : FragmentActivity() {

    companion object {
        const val EXTRA_MOVIE = "MovieDetails"
        const val SHARED_ELEMENT_NAME = "detail"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        MovieApplication.instance().appComponent.inject(this)

        val intent : Intent = getIntent()
        val action : String = intent.action
        val data : Uri = intent.data

        val imdbId : String = intent.getStringExtra("imdbId")

    }
}
