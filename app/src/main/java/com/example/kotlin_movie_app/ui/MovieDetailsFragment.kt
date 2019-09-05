package com.example.kotlin_movie_app.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.leanback.app.DetailsSupportFragment
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.ClassPresenterSelector
import com.example.kotlin_movie_app.MovieApplication
import com.example.kotlin_movie_app.model.MovieDetails
import javax.inject.Inject

class MovieDetailsFragment : DetailsSupportFragment(), MovieDetailsPresenter.MovieDetailsView {

    companion object {
        const val TAG : String = "MovieDetailsFragment"
    }

    private var selectedMovie : MovieDetails? = null

    private lateinit var sImdbId : String

    @Inject lateinit var movieDetailsPresenter : MovieDetailsPresenter

    private lateinit var detailsRowAdapter: ArrayObjectAdapter
    private lateinit var presenterSelector: ClassPresenterSelector

    override fun onCreate(savedInstanceState : Bundle?) {
        Log.i(TAG, "onCreate MovieDetailsFragment")
        super.onCreate(savedInstanceState)

        if (selectedMovie != null) {
            presenterSelector = ClassPresenterSelector()
            detailsRowAdapter = ArrayObjectAdapter(presenterSelector)


            adapter = detailsRowAdapter

        } else {
            val intent = Intent(activity, MoviesActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.i(TAG, "onActivityCreated")
        super.onActivityCreated(savedInstanceState)

        MovieApplication.instance().appComponent.inject(this)

        val intent = Intent(this@MovieDetailsFragment.context, MovieDetailsActivity::class.java)

        sImdbId = intent.getStringExtra("imdbId")

        detailsRowAdapter = ArrayObjectAdapter(DetailsDescriptionPresenter())
        movieDetailsPresenter.onAttach(this)
        movieDetailsPresenter.present(sImdbId)

    }

    override fun showMovieDetails(movieDetails : List<MovieDetails>) {
        loadMovieDetails(movieDetails)
    }

    override fun showError(error : String) {
        Toast.makeText(context, error, Toast.LENGTH_LONG).show()

    }

    private fun loadMovieDetails(movieDetails: Collection<MovieDetails>) {
        detailsRowAdapter = ArrayObjectAdapter()
        detailsRowAdapter.addAll(0, movieDetails)

        adapter = detailsRowAdapter

    }
}