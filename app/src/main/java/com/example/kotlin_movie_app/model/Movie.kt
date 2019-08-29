package com.example.kotlin_movie_app.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Movie class represents movie entity with rank, title, year, poster image, etc.
 */
data class Movie
@JsonCreator
constructor(
    @param:JsonProperty("poster") val poster: String,
    @param:JsonProperty("rank") val rank: Int,
    @param:JsonProperty("title") val title: String,
    @param:JsonProperty("year") val year: Int

)

data class MovieDetails
@JsonCreator
constructor(
    @param:JsonProperty("imdbRating") val imdbRating: Double,
    @param:JsonProperty("imdbVotes") val imdbVotes: Int,
    @param:JsonProperty("imdbId") val imdbId: String,
    @param:JsonProperty("title") val title: String,
    @param:JsonProperty("year") val year: Int,
    @param:JsonProperty("rated") val rated: String,
    @param:JsonProperty("released") val released: String,
    @param:JsonProperty("runtime") val runtime: String,
    @param:JsonProperty("genre") val genre: ArrayList<String>,
    @param:JsonProperty("director") val director: String,
    @param:JsonProperty("writer") val writer: String,
    @param:JsonProperty("actors") val actors: ArrayList<String>,
    @param:JsonProperty("plot") val plot: String,
    @param:JsonProperty("language") val language: ArrayList<String>,
    @param:JsonProperty("country") val country: String,
    @param:JsonProperty("awards") val awards: String,
    @param:JsonProperty("poster") val poster: String,
    @param:JsonProperty("metascore") val metascore: Int
)