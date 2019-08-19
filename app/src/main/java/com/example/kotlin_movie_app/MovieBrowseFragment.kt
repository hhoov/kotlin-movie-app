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


import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.leanback.app.BrowseSupportFragment

/**
 * Responsible for the UI of [MoviesActivity]. Loads a grid of cards with movies to browse.
 */
class MovieBrowseFragment : BrowseSupportFragment() {

    companion object {
        private const val TAG = "MovieBrowseFragment"

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.i(TAG, "onCreate")
        super.onActivityCreated(savedInstanceState)

        setupUIElements()

    }

    // Sets application title/icon and brand color
    private fun setupUIElements() {
        // Takes precedent over title when badge is set; puts badge in top right corner
        badgeDrawable = context?.getDrawable(R.drawable.banner)
        title = getString(R.string.browse_title)

        // Above title
        headersState = HEADERS_ENABLED
        isHeadersTransitionOnBackEnabled = true

        // Set headers (or fastlane) background color
        brandColor = ContextCompat.getColor(this.context!!, R.color.headers_background)
        // Set search icon color
        searchAffordanceColor = ContextCompat.getColor(this.context!!, R.color.search_opaque)
    }

}
