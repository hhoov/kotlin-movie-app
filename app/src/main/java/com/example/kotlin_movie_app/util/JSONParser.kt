package com.example.kotlin_movie_app.util

import android.R.attr.configure
import java.io.IOException
import com.example.kotlin_movie_app.MovieSummaryData
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper


class JSONParser {
    @Throws(IOException::class)
    fun readJsonStream(response: String): List<MovieSummaryData> {

        val mapper = ObjectMapper()

        // Config deserialization
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        // readValue deserializes JSON content from given JSON content String into Java object (using generics)
        return mapper.readValue(response, object : TypeReference<List<MovieSummaryData>>() {

        })
    }
}