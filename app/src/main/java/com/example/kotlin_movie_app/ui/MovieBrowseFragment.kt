package com.example.kotlin_movie_app

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat.getColor
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.*
import com.example.kotlin_movie_app.model.Movie

/**
 * Responsible for the UI of [MoviesActivity]. Loads a grid of cards with movies to browse.
 */
class MovieBrowseFragment : BrowseSupportFragment() {

    companion object {
        private const val TAG = "MovieBrowseFragment"
        private const val GRID_ITEM_WIDTH = 300
        private const val GRID_ITEM_HEIGHT = 200
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.i(TAG, "onCreate")
        super.onActivityCreated(savedInstanceState)

        setupUIElements()

        loadRows()
    }

    // Sets application title/icon and brand color
    private fun setupUIElements() {
        // Takes precedent over title when badge is set; puts badge in top right corner
        badgeDrawable = context?.getDrawable(R.drawable.app_icon_movies)

        // Set headers (or fastlane) background color
        brandColor = ContextCompat.getColor(this.context!!, R.color.headers_background)
    }

    private fun loadRows() {
        // RowsAdapter -- set of ListRow
        // ListRow -- HeaderItem + RowAdapter
        // RowAdapter -- set of Objects (movie card info)

        val rowsAdapter = ArrayObjectAdapter(ListRowPresenter())

        // MovieGridPresenter
        val movieGridPresenterHeaderItem = HeaderItem(0, "MovieGridPresenter")

        val movieGridPresenter = MovieGridPresenter()
        val movieGridRowAdapter = ArrayObjectAdapter(movieGridPresenter)

        movieGridRowAdapter.add("ITEM 1")
        movieGridRowAdapter.add("ITEM 2")
        movieGridRowAdapter.add("ITEM 3")
        rowsAdapter.add(ListRow(movieGridPresenterHeaderItem, movieGridRowAdapter))

        // CardPresenter
        val cardPresenterHeader = HeaderItem(1, "Movies")
        val cardPresenter = CardPresenter()
        val cardRowAdapter = ArrayObjectAdapter(cardPresenter)

        for (i in 1..10) {
            val movie = Movie(i, "Title $i", i, "imdbID $i", 1.0, i, "Poster $i", "imdbLink $i")
            cardRowAdapter.add(movie)
        }
        rowsAdapter.add(ListRow(cardPresenterHeader, cardRowAdapter))

        // BrowseSupportFragment's setAdapter()
        adapter = rowsAdapter
    }

private class MovieGridPresenter : Presenter(){

        override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
            val view = TextView(parent.context)
            view.layoutParams = ViewGroup.LayoutParams(GRID_ITEM_WIDTH, GRID_ITEM_HEIGHT)
            view.focusable
            view.isFocusableInTouchMode = true
            view.setBackgroundColor(getColor(parent.context.resources, R.color.default_background, null))
            view.setTextColor(Color.WHITE)
            view.gravity = Gravity.CENTER

            return ViewHolder(view)
        }

        override fun onBindViewHolder(viewHolder: ViewHolder, item: Any) {
            (viewHolder.view as TextView).text = item as String
        }

        override fun onUnbindViewHolder(viewHolder: ViewHolder) {
            // No op
        }
    }
}
