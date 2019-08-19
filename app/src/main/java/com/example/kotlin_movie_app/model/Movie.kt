package com.example.kotlin_movie_app.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Movie class represents movie entity with rank, title, year, poster image, etc.
 */
data class Movie
@JsonCreator
constructor(
    @param:JsonProperty("rank") val rank: Int,
    @param:JsonProperty("title") val title: String,
    @param:JsonProperty("year") val year: Int,
    @param:JsonProperty("imdbId") val imdbId: String,
    @param:JsonProperty("imdbRating") val imdbRating: Double,
    @param:JsonProperty("imdbVotes") val imdbVotes: Int,
    @param:JsonProperty("poster") val poster: String,
    @param:JsonProperty("imdbLink") val imdbLink: String
)

