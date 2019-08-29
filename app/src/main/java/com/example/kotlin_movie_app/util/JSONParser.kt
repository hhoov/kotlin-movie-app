package com.example.kotlin_movie_app.util

import java.io.IOException
import com.example.kotlin_movie_app.model.Movie
import com.example.kotlin_movie_app.model.MovieDetails
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper

class JSONParser {

    @Throws(IOException::class)
    fun readSummaryJsonStream(response: String): List<Movie> {
        val mapper = ObjectMapper()

        // Configures deserialization
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

        // readValue deserializes JSON content into object
        return mapper.readValue(response, object : TypeReference<List<Movie>>(){})
    }

    @Throws(IOException::class)
    fun readDetailsJsonStream(response: String) : List<MovieDetails> {
        val mapper = ObjectMapper()

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

        return mapper.readValue(response, object: TypeReference<List<MovieDetails>>(){})
    }

}