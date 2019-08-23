package com.example.kotlin_movie_app

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.leanback.widget.ImageCardView
import androidx.leanback.widget.Presenter
import com.example.kotlin_movie_app.model.Movie

class CardPresenter : Presenter() {

    companion object {
        private const val TAG = "CardPresenter"
        private const val CARD_WIDTH = 313
        private const val CARD_HEIGHT = 176
    }

    class ViewHolder(view: View) : Presenter.ViewHolder(view) {
        private lateinit var movie : Movie
        private val cardView : ImageCardView
        private val defaultCardImage : Drawable

       init {
            super.view
            cardView = view as ImageCardView
            defaultCardImage = ContextCompat.getDrawable(view.context, R.drawable.movie)!!
        }

        fun setMovie(m : Movie) {
            movie = m
        }

        fun getCardView() : ImageCardView {
            return cardView
        }

        fun getDefaultCardImage() : Drawable {
            return defaultCardImage
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        Log.d(TAG, "onCreateViewHolder")

        val cardView = ImageCardView(parent.context)
        cardView.focusable
        cardView.isFocusableInTouchMode = true
        cardView.setBackgroundColor(ContextCompat.getColor(parent.context, R.color.headers_background))

        return ViewHolder(cardView)
    }

    override fun onBindViewHolder(viewHolder: Presenter.ViewHolder, item: Any) {
        val movie = item as Movie
        (viewHolder as ViewHolder).setMovie(movie)

        Log.d(TAG, "onBindViewHolder")
        viewHolder.getCardView().titleText = movie.title
        viewHolder.getCardView().contentText = movie.imdbId
        viewHolder.getCardView().setMainImageDimensions(CARD_WIDTH, CARD_HEIGHT)
        viewHolder.getCardView().mainImage = viewHolder.getDefaultCardImage()
    }

    override fun onUnbindViewHolder(viewHolder: Presenter.ViewHolder) {
        Log.d(TAG, "onUnbindViewHolder")
    }
}