package com.example.kotlin_movie_app.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.*
import com.example.kotlin_movie_app.MovieApplication
import com.example.kotlin_movie_app.R
import com.example.kotlin_movie_app.model.Movie
import java.io.Serializable
import javax.inject.Inject

/**
 * Responsible for the UI of [MoviesActivity]. Loads a grid of cards with movies to browse.
 */
class MovieBrowseFragment : BrowseSupportFragment(), MoviePresenter.MovieView {

    companion object { private const val TAG = "MovieBrowseFragment" }

    @Inject lateinit var moviePresenter : MoviePresenter
    private lateinit var rowsAdapter : ArrayObjectAdapter
    private lateinit var moviesRowHeader : HeaderItem
    private lateinit var moviesRowAdapter : ArrayObjectAdapter
    private lateinit var cardPresenter : CardPresenter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.i(TAG, "onCreate")
        super.onActivityCreated(savedInstanceState)

        MovieApplication.instance().appComponent.inject(this)

        // Takes precedent over title when badge is set; puts badge in top right corner
        badgeDrawable = context?.getDrawable(R.drawable.app_icon_movies)

        // Sets the headers (or fastlane) background color
        brandColor = ContextCompat.getColor(this.context!!, R.color.headers_background)

        rowsAdapter = ArrayObjectAdapter(ListRowPresenter())

        cardPresenter = CardPresenter()

        moviePresenter.onAttach(this)
        moviePresenter.present()
    }

    override fun updateMovies(movies: List<Movie>) {
        loadRows(movies)
    }

    override fun showError(error: String) {
        Toast.makeText(context, error, Toast.LENGTH_LONG).show()
    }

    private fun loadRows(movies : Collection<Movie>) {

        moviesRowAdapter = ArrayObjectAdapter(cardPresenter)
        moviesRowAdapter.addAll(0, movies)

        moviesRowHeader = HeaderItem(1, getString(R.string.browse_header))

        rowsAdapter.add(ListRow(moviesRowHeader, moviesRowAdapter))

        // BrowseSupportFragment's setAdapter()
        adapter = rowsAdapter
    }
}