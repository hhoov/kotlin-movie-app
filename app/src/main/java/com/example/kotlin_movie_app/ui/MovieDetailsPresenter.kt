package com.example.kotlin_movie_app.ui

import com.example.kotlin_movie_app.data.MovieDetailsProvider
import com.example.kotlin_movie_app.model.MovieDetails
import com.example.kotlin_movie_app.util.NullObject
import com.example.kotlin_movie_app.util.UIExecutor
import java.io.IOException
import java.util.concurrent.Executor
import javax.inject.Inject

class MovieDetailsPresenter @Inject constructor(
    private val movieDetailsProvider : MovieDetailsProvider,
    private val backgroundExecutor : Executor,
    private val uiExecutor: UIExecutor
) {

    private val NULLVIEW : MovieDetailsView = NullObject.create(MovieDetailsView::class.java)

    private var view : MovieDetailsView = NULLVIEW

    fun present(imdbID : String){
        backgroundExecutor.execute {
            try {
                val movieDetailData: List<MovieDetails> = movieDetailsProvider.getMovieDetailsData(imdbID)
                uiExecutor.execute {
                    view.showMovieDetails(movieDetailData)
                }
            } catch (e : IOException) {
                uiExecutor.execute {
                    view.showError(e.toString())
                }
            }
        }
    }

    fun onAttach(view : MovieDetailsView) {
        this.view = view
    }

    interface MovieDetailsView {
        fun showMovieDetails(movieDetails : List<MovieDetails>)
        fun showError(error : String)
    }

}