package com.example.kotlin_movie_app.ui

import android.util.Log
import androidx.leanback.widget.AbstractDetailsDescriptionPresenter
import com.example.kotlin_movie_app.model.Movie
import com.example.kotlin_movie_app.model.MovieDetails

class MovieDetailsDescriptionPresenter : AbstractDetailsDescriptionPresenter() {

    override fun onBindDescription(vh: ViewHolder?, item: Any?) {
        val movie : MovieDetails = item as MovieDetails

        if (movie != null) {
            Log.d("DetailPresenter", "${movie.title} ${movie.poster} ${movie.plot}")
            vh?.title?.text = movie.title
            vh?.subtitle?.text = movie.year.toString()
            vh?.body?.text = movie.plot
        }
    }
}