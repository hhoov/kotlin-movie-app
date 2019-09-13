package com.example.kotlin_movie_app.ui

import android.content.Intent
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
import com.example.kotlin_movie_app.util.Constants
import kotlinx.android.synthetic.main.card_movie.view.*

class CardPresenter : Presenter() {

    companion object {
        private const val TAG = "CardPresenter"
    }

    class ViewHolder(view: View) : Presenter.ViewHolder(view){
        private lateinit var movie : Movie
        val posterImageView : ImageView
        val rankTextView : TextView
        val titleTextView : TextView
        val yearTextView : TextView

       init {
           super.view
           posterImageView = view.poster
           rankTextView = view.rankTextView
           titleTextView = view.titleTextView
           yearTextView = view.yearTextView

           view.setOnClickListener {
               Log.d(TAG, " -- setOnClickListener")
               val intent = Intent(it.context, MovieDetailsActivity::class.java)
               //val intent = Intent(Intent.ACTION_SEND)
               //intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
               intent.putExtra("imdbId", movie.imdbId)
               //intent.putExtra("imdbId", movie.imdbId)
               it.context.startActivity(intent)
           }
       }

        fun setMovie(m : Movie) {
            movie = m
        }
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

        val selectedImdbId : String = movie.imdbId

        viewHolder.rankTextView.text = movie.rank.toString()
        viewHolder.titleTextView.text = movie.title
        viewHolder.yearTextView.text = movie.year.toString()

        Log.d(TAG, "-------         ----------      ---------")
        Log.d(TAG, "viewHolder.view -- " + viewHolder.view)
        Log.d(TAG, "vH.view.context -- " + viewHolder.view.context)
        Log.d(TAG, "movie.poster -- " + movie.poster)
        Log.d(TAG, "vH.getPosterImageView() -- " + viewHolder.posterImageView)
        Log.d(TAG, "-------         ----------      ---------")

        Glide.with(viewHolder.view.context)
            .load(Constants.TEST_IMAGE_URL)
            .centerCrop()
            .placeholder(R.drawable.lb_ic_loop) // placeholder before Glide starts loading the image
            .error(R.drawable.ic_launcher) // when Glide is unable to load the image + non-existing-url
            .fallback(R.drawable.lb_ic_stop) // when the url can be null
            .into(viewHolder.posterImageView)
    }

    override fun onUnbindViewHolder(viewHolder: Presenter.ViewHolder) {
        Log.d(TAG, "onUnbindViewHolder")
    }
}