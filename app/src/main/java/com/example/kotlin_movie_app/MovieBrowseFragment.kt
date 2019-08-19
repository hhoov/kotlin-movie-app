/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

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

/**
 * Responsible for the UI of [MoviesActivity]. Loads a grid of cards with movies to browse.
 */
class MovieBrowseFragment : BrowseSupportFragment() {

    private lateinit var rowsAdapter : ArrayObjectAdapter

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
        //badgeDrawable = context?.getDrawable(R.drawable.app_icon_movies)
        title = getString(R.string.browse_title)

        // Above title
        headersState = HEADERS_ENABLED
        isHeadersTransitionOnBackEnabled = true

        // Set headers (or fastlane) background color
        brandColor = ContextCompat.getColor(this.context!!, R.color.headers_background)
        // Set search icon color
        searchAffordanceColor = ContextCompat.getColor(this.context!!, R.color.search_opaque)
    }

    private fun loadRows() {
        // RowsAdapter -- set of ListRow
        // ListRow -- HeaderItem + RowAdapter
        // RowAdapter -- set of Objects (movie card info)

        rowsAdapter = ArrayObjectAdapter(ListRowPresenter())

        // MovieGridPresenter
        val movieGridPresenterHeaderItem = HeaderItem(0, "MovieGridPresenter")

        val movieGridPresenter = MovieGridPresenter()
        val movieGridRowAdapter = ArrayObjectAdapter(movieGridPresenter)

        movieGridRowAdapter.add("ITEM 1")
        movieGridRowAdapter.add("ITEM 2")
        movieGridRowAdapter.add("ITEM 3")
        rowsAdapter.add(ListRow(movieGridPresenterHeaderItem, movieGridRowAdapter))

        adapter = rowsAdapter
    }

private class MovieGridPresenter : Presenter(){

        override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
            val view = TextView(parent.context)
            view.layoutParams = ViewGroup.LayoutParams(GRID_ITEM_WIDTH, GRID_ITEM_HEIGHT)
            view.focusable = parent.focusable
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
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }


}
