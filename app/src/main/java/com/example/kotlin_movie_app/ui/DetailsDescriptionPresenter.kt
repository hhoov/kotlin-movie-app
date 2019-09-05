package com.example.kotlin_movie_app.ui

import androidx.leanback.widget.AbstractDetailsDescriptionPresenter
import com.example.kotlin_movie_app.model.MovieDetails

/**
 * AbstractDetailsDescriptionPresenter decides the design layout of description view
 */
class DetailsDescriptionPresenter : AbstractDetailsDescriptionPresenter() {

    override fun onBindDescription(viewHolder : ViewHolder, itemData: Any) {
        val details = itemData as MovieDetails

        viewHolder.apply {
            title.text = details.title
            subtitle.text = details.year.toString()
            body.text = details.plot
        }
    }
}