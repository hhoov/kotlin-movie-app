package com.example.kotlin_movie_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_movie_app.model.Movie

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private lateinit var movieData : ArrayList<Movie>

    init {
        MovieAdapter()
    }

    fun Int.onBindViewHolder(holder: RecyclerView.ViewHolder) {

    }

    override fun getItemCount(): Int {
        return movieData.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view : View
        view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item_view, parent, false)
        var vh : RecyclerView.ViewHolder()
        return vh
    }

    class ViewHolder : RecyclerView.ViewHolder(), MoviesPresenter.MoviesView {
        lateinit var imageView : ImageView
        lateinit var rankTextView : TextView
        lateinit var titleTextView : TextView
        lateinit var yearTextView: TextView
        lateinit var imdbIdTextView: TextView
        lateinit var imdbRatingTextView: TextView
        lateinit var imdbVotesTextView: TextView
        lateinit var imdbLinkTextView: TextView
        lateinit var moviePresenter: MoviesPresenter

        inner class ViewHolder(v : View) {
            /*super(v)
            imageView = v.findByViewId*/

        }
    }
}