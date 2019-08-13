package com.example.kotlin_movie_app

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.kotlin_movie_app.model.Movie

class MoviesActivity : FragmentActivity(), MoviesPresenter.MoviesView {

    override fun displayMovies(moviesList: List<Movie>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    lateinit var moviesPresenter: MoviesPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MovieApplication.instance().appComponent.inject(this)
        setContentView(R.layout.activity_movies)
    }



}