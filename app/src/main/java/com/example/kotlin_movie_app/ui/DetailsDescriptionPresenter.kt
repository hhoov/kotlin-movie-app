package com.example.kotlin_movie_app.ui

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
import com.example.kotlin_movie_app.model.MovieDetails
import com.example.kotlin_movie_app.util.Constants
import kotlinx.android.synthetic.main.frag_movie_details.view.*

/**
 * AbstractDetailsDescriptionPresenter decides the design layout of description view
 */
class DetailsDescriptionPresenter : Presenter() {

    companion object {
        private const val TAG : String = "DetailsDescriptionPresenter"
    }

    class ViewHolder(view : View) : Presenter.ViewHolder(view) {
        private lateinit var movieDetail : MovieDetails
        val posterImageView : ImageView
        val titleTextView : TextView
        val yearTextView : TextView
        val plotTextView : TextView

        init {
            super.view
            posterImageView = view.poster
            titleTextView = view.titleTextView
            yearTextView = view.yearTextView
            plotTextView = view.plotTextView
        }

        fun setMovieDetail(md : MovieDetails) {
            movieDetail = md
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        Log.d(TAG, "onCreateViewHolder")
        val descriptionView = LayoutInflater.from(parent.context).inflate(R.layout.frag_movie_details, parent, false)
        descriptionView.focusable
        descriptionView.isFocusableInTouchMode = true
        descriptionView.setBackgroundColor(ContextCompat.getColor(parent.context,
            R.color.headers_background))

        return ViewHolder(descriptionView)
    }

    override fun onBindViewHolder(viewHolder : Presenter.ViewHolder, itemData: Any) {
        val details = itemData as MovieDetails
        (viewHolder as ViewHolder).setMovieDetail(details)

        /*viewHolder.apply {
            title.text = details.title
            subtitle.text = details.year.toString()
            body.text = details.plot
        }*/

        viewHolder.titleTextView.text = details.title
        viewHolder.yearTextView.text = details.year.toString()
        viewHolder.plotTextView.text = details.plot

        Glide.with(viewHolder.view.context)
            .load(Constants.TEST_IMAGE_URL)
            .centerCrop()
            .placeholder(R.drawable.lb_ic_loop)
            .error(R.drawable.ic_launcher)
            .fallback(R.drawable.lb_ic_stop)
            .into(viewHolder.posterImageView)
    }

    override fun onUnbindViewHolder(viewHolder: Presenter.ViewHolder?) {
        Log.d(TAG, "onUnbindViewHolder")
    }
}