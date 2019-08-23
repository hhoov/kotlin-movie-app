package com.example.kotlin_movie_app.ui

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.leanback.widget.ImageCardView
import androidx.leanback.widget.Presenter
import com.example.kotlin_movie_app.R
import com.example.kotlin_movie_app.model.Movie
import kotlinx.android.synthetic.main.card_movie.view.*

class CardPresenter : Presenter() {

    companion object {
        private const val TAG = "CardPresenter"
        private const val CARD_WIDTH = 313
        private const val CARD_HEIGHT = 176
    }

    private var movieData : List<Movie> = ArrayList()

    class ViewHolder(view: View) : Presenter.ViewHolder(view) {
        private lateinit var movie : Movie
        //private val cardView : ImageCardView
        private val defaultCardImage : Drawable
        private val rankTextView : TextView
        private val titleTextView : TextView
        private val yearTextView : TextView
        private val imdbIdTextView : TextView
        private val imdbRatingTextView : TextView
        private val imdbVotesTextView : TextView
        private val imdbLinkTextView : TextView

       init {
           super.view
           //cardView = view as ImageCardView
           defaultCardImage = ContextCompat.getDrawable(view.context, R.drawable.movie)!!
           rankTextView = view.rankTextView
           titleTextView = view.titleTextView
           yearTextView = view.yearTextView
           imdbIdTextView = view.imdbIdTextView
           imdbRatingTextView = view.imdbRatingTextView
           imdbVotesTextView = view.imdbVotesTextView
           imdbLinkTextView = view.imdbLinkTextView

        }

        fun setMovie(m : Movie) {
            movie = m
        }

        /*fun getCardView() : ImageCardView {
            return cardView
        }*/

        fun getRankTextView() : TextView { return rankTextView }
        fun getTitleTextView() : TextView { return titleTextView }
        fun getYearTextView() : TextView { return yearTextView }
        fun getImdbIdTextView() : TextView { return imdbIdTextView }
        fun getImdbRatingTextView() : TextView { return imdbRatingTextView }
        fun getImdbVotesTextView() : TextView { return imdbVotesTextView }
        fun getImdbLinkTextView() : TextView { return imdbLinkTextView }

        fun getDefaultCardImage() : Drawable { return defaultCardImage }
    }

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        Log.d(TAG, "onCreateViewHolder")

        val cardView = LayoutInflater.from(parent.context).inflate(R.layout.card_movie, parent, false)
        cardView.focusable
        cardView.isFocusableInTouchMode = true
        cardView.setBackgroundColor(ContextCompat.getColor(parent.context,
            R.color.headers_background
        ))

        return ViewHolder(cardView)
    }

    override fun onBindViewHolder(viewHolder: Presenter.ViewHolder, item: Any) {
        val movie = item as Movie
        (viewHolder as ViewHolder).setMovie(movie)

        //viewHolder.getCardView().titleText = movie.title
        //viewHolder.getCardView().contentText = movie.imdbId
        /*viewHolder.getCardView().setMainImageDimensions(
            CARD_WIDTH,
            CARD_HEIGHT
        )
        viewHolder.getCardView().mainImage = viewHolder.getDefaultCardImage()*/

        viewHolder.getRankTextView().text = movie.rank.toString()
        viewHolder.getTitleTextView().text = movie.title
        viewHolder.getYearTextView().text = movie.year.toString()
        viewHolder.getImdbIdTextView().text = movie.imdbId
        viewHolder.getImdbRatingTextView().text = movie.imdbRating.toString()
        viewHolder.getImdbVotesTextView().text = movie.imdbVotes.toString()
        viewHolder.getImdbLinkTextView().text = movie.imdbLink
    }

    override fun onUnbindViewHolder(viewHolder: Presenter.ViewHolder) {
        Log.d(TAG, "onUnbindViewHolder")
    }
}