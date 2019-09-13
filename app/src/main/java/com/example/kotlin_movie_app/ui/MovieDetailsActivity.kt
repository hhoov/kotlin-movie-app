package com.example.kotlin_movie_app.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.leanback.widget.AbstractDetailsDescriptionPresenter
import com.example.kotlin_movie_app.MovieApplication
import com.example.kotlin_movie_app.R
import com.example.kotlin_movie_app.model.MovieDetails
import javax.inject.Inject

class MovieDetailsActivity : FragmentActivity(), MovieDetailsPresenter.MovieDetailsView {

    companion object {
        const val EXTRA_MOVIE = "MovieDetails"
        const val SHARED_ELEMENT_NAME = "detail"
    }
    @Inject
    lateinit var movieDetailsPresenter : MovieDetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        MovieApplication.instance().appComponent.inject(this)




        val intent : Intent = intent

        val imdbId : String = intent.getStringExtra("imdbId")

        val bundle : Bundle = Bundle()
        bundle.putString("imdbId", imdbId)

        val detailFrag : MovieDetailsFragment = MovieDetailsFragment()
        detailFrag.arguments = bundle


        movieDetailsPresenter.onAttach(this)
        movieDetailsPresenter.present(imdbId)
    }

    override fun showMovieDetails(movieDetails: List<MovieDetails>) {
        class DetailsDescriptionPresenter : AbstractDetailsDescriptionPresenter() {
            override fun onBindDescription(vh: ViewHolder?, item: Any?) {
                val details : MovieDetails = item as MovieDetails

                vh.apply {
                    vh!!.title.text = details.title
                }
            }

        }
    }

    override fun showError(error: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
