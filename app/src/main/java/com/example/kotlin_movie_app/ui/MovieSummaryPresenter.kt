package com.example.kotlin_movie_app.ui

import android.util.Log
import com.example.kotlin_movie_app.util.NullObject

class MovieSummaryPresenter constructor(private val imdbId : String) {

    private val NULL_VIEW: MovieSummaryView = NullObject.create(MovieSummaryView::class.java)

    private var view: MovieSummaryView = NULL_VIEW

    fun onMovieClicked() {
        Log.d("MovieSummaryPresenter", " -- onMovieClicked()")
        view.startDetailActivity(imdbId)
    }

    interface MovieSummaryView {

        fun startDetailActivity(imdbId : String)
    }
}