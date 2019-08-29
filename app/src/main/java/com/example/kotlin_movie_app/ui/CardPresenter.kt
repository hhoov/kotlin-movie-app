package com.example.kotlin_movie_app.ui

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.leanback.widget.Presenter
import com.bumptech.glide.Glide
import com.example.kotlin_movie_app.R
import com.example.kotlin_movie_app.model.Movie
import kotlinx.android.synthetic.main.card_movie.view.*

class CardPresenter : Presenter() {

    companion object {
        private const val TAG = "CardPresenter"
    }

    class ViewHolder(view: View) : Presenter.ViewHolder(view) {
        private lateinit var movie : Movie
        private val posterImageView : ImageView
        private val defaultCardImage : Drawable
        private val rankTextView : TextView
        private val titleTextView : TextView
        private val yearTextView : TextView

       init {
           super.view
           posterImageView = view.poster
           defaultCardImage = ContextCompat.getDrawable(view.context, R.drawable.movie)!!
           rankTextView = view.rankTextView
           titleTextView = view.titleTextView
           yearTextView = view.yearTextView
        }

        fun setMovie(m : Movie) {
            movie = m
        }

        fun getPosterImageView() : ImageView { return posterImageView }
        fun getRankTextView() : TextView { return rankTextView }
        fun getTitleTextView() : TextView { return titleTextView }
        fun getYearTextView() : TextView { return yearTextView }

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

        viewHolder.getRankTextView().text = movie.rank.toString()
        viewHolder.getTitleTextView().text = movie.title
        viewHolder.getYearTextView().text = movie.year.toString()

        Log.d(TAG, "-------         ----------      ---------")
        Log.d(TAG, "viewHolder.view -- " + viewHolder.view)
        Log.d(TAG, "vH.view.context -- " + viewHolder.view.context)
        Log.d(TAG, "movie.poster -- " + movie.poster)
        Log.d(TAG, "vH.getPosterImageView() -- " + viewHolder.getPosterImageView())
        Log.d(TAG, "-------         ----------      ---------")

        Glide.with(viewHolder.view.context)
            .load("https://static.techspot.com/images2/downloads/topdownload/2019/07/2019-07-17-ts3_thumbs-9d7.png")
            .centerCrop()
            .placeholder(R.drawable.lb_ic_loop) // placeholder before Glide starts loading the image
            .error(R.drawable.ic_launcher) // when Glide is unable to load the image + non-existing-url
            .fallback(R.drawable.lb_ic_stop) // when the url can be null
            .into(viewHolder.getPosterImageView())
    }

    override fun onUnbindViewHolder(viewHolder: Presenter.ViewHolder) {
        Log.d(TAG, "onUnbindViewHolder")
    }
}