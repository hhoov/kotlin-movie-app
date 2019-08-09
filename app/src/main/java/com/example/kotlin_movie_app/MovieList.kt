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

object MovieList {
    val MOVIE_CATEGORY = arrayOf(
        "Category Zero",
        "Category One",
        "Category Two",
        "Category Three",
        "Category Four",
        "Category Five"
    )

    val list: List<Movie> by lazy {
        setupMovies()
    }
    private var count: Long = 0

    private fun setupMovies(): List<Movie> {
        val rank = arrayOf(
            0,
            1,
            2,
            3,
            4,
            5
        )
        val title = arrayOf(
            "Zeitgeist 2010_ Year in Review",
            "Google Demo Slam_ 20ft Search",
            "Introducing Gmail Blue",
            "Introducing Google Fiber to the Pole",
            "Introducing Google Nose"
        )
        val year = arrayOf(
            2000,
            2001,
            2002,
            2003,
            2004
        )
        val imdbId = arrayOf(
            "Studio Zero",
            "Studio One",
            "Studio Two",
            "Studio Three",
            "Studio Four"
        )
        val imdbRating = arrayOf(
            0.0,
            1.1,
            2.2,
            3.3,
            4.4
        )
        val imdbVotes = arrayOf(
            1111L,
            2222L,
            3333L,
            4444L,
            5555L
        )
        val poster = arrayOf(
            "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review/card.jpg",
            "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/Demo%20Slam/Google%20Demo%20Slam_%2020ft%20Search/card.jpg",
            "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Gmail%20Blue/card.jpg",
            "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Google%20Fiber%20to%20the%20Pole/card.jpg",
            "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Google%20Nose/card.jpg"
        )
        val imdbLink = arrayOf(
            "http",
            "http",
            "http",
            "http",
            "http"
        )
        val list = title.indices.map {
            buildMovieInfo(
                rank[it],
                title[it],
                year[it],
                imdbId[it],
                imdbRating[it],
                imdbVotes[it],
                poster[it],
                imdbLink[it]
            )
        }

        return list
    }

    private fun buildMovieInfo(
        rank: Int,
        title: String,
        year: Int,
        imdbId: String,
        imdbRating: Double,
        imdbVotes: Long,
        poster: String,
        imdbLink: String
    ): Movie {
        val movie = Movie()
        movie.rank = rank
        movie.title = title
        movie.year = year
        movie.imdbId = imdbId
        movie.imdbRating = imdbRating
        movie.imdbVotes = imdbVotes
        movie.poster = poster
        movie.imdbLink = imdbLink
        return movie
    }
}