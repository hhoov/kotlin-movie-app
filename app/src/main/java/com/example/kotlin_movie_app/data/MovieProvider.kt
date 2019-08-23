package com.example.kotlin_movie_app.data

import com.example.kotlin_movie_app.model.Movie
import com.example.kotlin_movie_app.util.Constants
import com.example.kotlin_movie_app.util.JSONParser
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieProvider @Inject constructor(private val okHttpClient: OkHttpClient) {
    private var jsonData : String = ""

    private var jsonParser = JSONParser()

    @Throws(IOException::class)
    fun getMovieData() : List<Movie> {
        jsonData = makeRequest(Constants.BASE_URL)
        return jsonParser.readJsonStream(jsonData)
    }

    private fun makeRequest(url : String) : String {
        try {
            val request = Request.Builder()
                .url(url)
                .build()
            var response : Response? = null
            try {
                response = okHttpClient.newCall(request).execute()
            } catch (e : IOException) {
                e.printStackTrace()
            }

            jsonData = response!!.body!!.string()
        } catch (e : IOException) {
            e.printStackTrace()
        }
        return jsonData
    }
}