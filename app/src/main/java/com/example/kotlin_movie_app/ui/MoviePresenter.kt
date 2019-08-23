package com.example.kotlin_movie_app.ui

import com.example.kotlin_movie_app.UIExecutor
import com.example.kotlin_movie_app.data.MovieProvider
import com.example.kotlin_movie_app.model.Movie
import com.example.kotlin_movie_app.util.NullObject
import java.io.IOException
import java.util.concurrent.Executor
import javax.inject.Inject

class MoviePresenter @Inject constructor(
    private val movieProvider: MovieProvider,
    private val backgroundExecutor: Executor,
    private val uiExecutor: UIExecutor
) {
    private val NULL_VIEW: MovieView = NullObject.create(MovieView::class.java)

    private var view: MovieView = NULL_VIEW

    fun present() {
        backgroundExecutor.execute {
            try {
                val movieData: List<Movie> = movieProvider.getMovieData()
                uiExecutor.execute {
                    view.updateMovies(movieData)
                }
            } catch (e: IOException) {
                uiExecutor.execute {
                    view.showError(e.toString())
                }
            }
        }
    }

    fun onAttach(view: MovieView) {
        this.view = view
    }

    interface MovieView {
        fun updateMovies(movies: List<Movie>)

        fun showError(error: String)
    }
}