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


import android.app.Activity
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.Gravity
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.leanback.app.BackgroundManager
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.*
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import com.example.kotlin_movie_app.model.Movie
import java.util.*

/*import com.example.kotlin_movie_app.presenter.CardPresenter
import com.example.kotlin_movie_app.presenter.GridItemPresenter
import com.example.kotlin_movie_app.presenter.IconHeaderItemPresenter
import com.example.kotlin_movie_app.recommendation.UpdateRecommendationsService*/

/**
 * Loads a grid of cards with movies to browse.
 */
class MainFragment : BrowseSupportFragment() {

    private var moviesUrl: String = ""
    private lateinit var backgroundManager: BackgroundManager
    private var defaultBackground: Drawable? = null
    private lateinit var metrics: DisplayMetrics
    private lateinit var backgroundUri: Uri


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.i(TAG, "onCreate")
        super.onActivityCreated(savedInstanceState)

        prepareBackgroundManager(activity!!)

        setupUIElements()

        loadRows()

        setupEventListeners()

    }

    private fun prepareBackgroundManager(activity : Activity) {

        backgroundManager = BackgroundManager.getInstance(activity)
        backgroundManager.attach(activity.window)
        defaultBackground = activity.getDrawable(R.drawable.default_background)
        metrics = DisplayMetrics()
        activity.windowManager!!.defaultDisplay!!.getMetrics(metrics)
    }

    private fun setupUIElements() {
        // Takes precedent over title when badge is set; puts badge in top right corner
        badgeDrawable = context?.getDrawable(R.drawable.banner)
        title = getString(R.string.browse_title)
        // Headers enabled
        headersState = HEADERS_ENABLED
        isHeadersTransitionOnBackEnabled = true

        // Set headers background color
        brandColor = ContextCompat.getColor(this.context!!, R.color.headers_background)
        // Set search icon color
        searchAffordanceColor = ContextCompat.getColor(this.context!!, R.color.search_opaque)
    }

    private fun loadVideoData() {
       // MovieProvider.setContext(activity)
        moviesUrl = resources.getString(R.string.movie_url)
    }

    private fun setupEventListeners() {
        setOnSearchClickedListener {
            Toast.makeText(activity, "Implement your own in-app search", Toast.LENGTH_LONG)
                .show()
        }

        onItemViewClickedListener = ItemViewClickedListener()
        onItemViewSelectedListener = ItemViewSelectedListener()
    }

    private fun loadRows() {
        val list = MovieList.list

        val rowsAdapter = ArrayObjectAdapter(ListRowPresenter())
        val cardPresenter = CardPresenter()

        for (i in 0 until NUM_ROWS) {
            if (i != 0) {
                Collections.shuffle(list)
            }
            val listRowAdapter = ArrayObjectAdapter(cardPresenter)
            for (j in 0 until NUM_COLS ) {
                listRowAdapter.add(list[j % 5])
            }
                val header = HeaderItem(i.toLong(), MovieList.MOVIE_CATEGORY[i])
            rowsAdapter.add(ListRow(header, listRowAdapter))
        }

            val gridHeader = HeaderItem(NUM_ROWS.toLong(), "PREFERENCES")

        val mGridPresenter = GridItemPresenter()
        val gridRowAdapter = ArrayObjectAdapter(mGridPresenter)
        gridRowAdapter.add(resources.getString(R.string.grid_view))
        rowsAdapter.add(ListRow(gridHeader, gridRowAdapter))

        adapter = rowsAdapter
    }


    private inner class ItemViewClickedListener : OnItemViewClickedListener {
        override fun onItemClicked(
                itemViewHolder: Presenter.ViewHolder,
                item: Any,
                rowViewHolder: RowPresenter.ViewHolder,
                row: Row) {

            if (item is Movie) {
                Log.d(TAG, "Item: $item")
                //val intent = Intent(activity, DetailsActivity::class.java)
                //intent.putExtra(DetailsActivity.MOVIE, item)

                /*val bundle = ActivityOptionsCompat.makeSceneTransitionAnimation(
                                                activity!!,
                                                (itemViewHolder.view as ImageCardView).mainImageView,
                                                DetailsActivity.SHARED_ELEMENT_NAME)
                                        .toBundle()*/
                //activity?.startActivity(intent, bundle)
            }
        }
    }

    private inner class ItemViewSelectedListener : OnItemViewSelectedListener {
        override fun onItemSelected(itemViewHolder: Presenter.ViewHolder?, item: Any?,
                                    rowViewHolder: RowPresenter.ViewHolder, row: Row) {
            if (item is Movie) {
                //backgroundUri = item.poster
            }
        }
    }

    private fun updateBackground(uri: String?) {
        val width = metrics.widthPixels
        val height = metrics.heightPixels

        var options = RequestOptions()
            .centerCrop()
            .error(defaultBackground)

        Glide.with(activity)
                .asDrawable()
                .load(uri)
                .apply(options)
                .into<SimpleTarget<Drawable>>(
                        object : SimpleTarget<Drawable>(width, height) {
                            override fun onResourceReady(resource: Drawable,
                                                         glideAnimation: Transition<in Drawable>) {
                                backgroundManager.drawable = resource
                            }
                        })
    }

    private inner class GridItemPresenter : Presenter() {
        override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
            val view = TextView(parent.context)
            view.layoutParams = ViewGroup.LayoutParams(GRID_ITEM_WIDTH, GRID_ITEM_HEIGHT)
            view.isFocusable = true
            view.isFocusableInTouchMode = true
            view.setBackgroundColor(ContextCompat.getColor(parent.context, R.color.default_background))
            view.setTextColor(Color.WHITE)
            view.gravity = Gravity.CENTER
            return ViewHolder(view)
        }

        override fun onBindViewHolder(viewHolder: ViewHolder, item: Any) {
            (viewHolder.view as TextView).text = item as String
        }

        override fun onUnbindViewHolder(viewHolder: ViewHolder) {}
    }

    companion object {
        private const val TAG = "MainFragment"

        private const val GRID_ITEM_WIDTH = 200
        private const val GRID_ITEM_HEIGHT = 200
        private const val NUM_ROWS = 6
        private const val NUM_COLS = 15
    }
}
