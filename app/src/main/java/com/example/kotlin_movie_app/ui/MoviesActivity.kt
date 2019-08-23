package com.example.kotlin_movie_app

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentActivity
import androidx.loader.app.LoaderManager
import androidx.loader.content.Loader
import com.example.kotlin_movie_app.model.Movie

/**
 * Loads [MovieBrowseFragment]
 */

class MoviesActivity : FragmentActivity() {

    companion object {
        private const val TAG = "MoviesActivity"
        private const val VIDEO_ITEM_LOADER_ID = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)
        getLoaderManager().initLoader(VIDEO_ITEM_LOADER_ID, null, MoviesFragmentLoaderCallbacks())
    }

    private class MoviesFragmentLoaderCallbacks : LoaderManager.LoaderCallbacks<HashMap<String, List<Movie>>> {

        override fun onCreateLoader(id: Int, args: Bundle?): Loader<HashMap<String, List<Movie>>> {
            // Create new Loader
            Log.d(TAG, "MovieItemLoader: on CreateLoader")
            return MovieItemLoader()
        }

        override fun onLoadFinished(loader: Loader<HashMap<String, List<Movie>>>, data: HashMap<String, List<Movie>>?) {
            Log.d(TAG, "MovieItemLoader: onLoadFinished")
            // Loader data has prepared. Start updating UI here

            when (loader.id) {
                VIDEO_ITEM_LOADER_ID -> {
                    Log.d(TAG, "VideoLists UI Update")

                    // Hold data reference to use it for recommendation
                    // TODO

                }

            }
        }

        override fun onLoaderReset(loader: Loader<HashMap<String, List<Movie>>>) {
            Log.d(TAG, "MovieItemLoader: onLoadReset")
            // When called, Loader data is now unavailable due to some reason
        }

    }
}