package com.example.kotlin_movie_app.data

import com.example.kotlin_movie_app.model.MovieDetails
import com.example.kotlin_movie_app.util.Constants
import com.example.kotlin_movie_app.util.JSONParser
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieDetailsProvider @Inject constructor(private val okHttpClient: OkHttpClient) {

    private var jsonDetailData : String = ""
    private val jsonExtension : String = ".json"
    private var jsonParser = JSONParser()

    @Throws(IOException::class)
    fun getMovieDetailsData(imdbId : String) : List<MovieDetails> {
        val urlByImdbId : String = Constants.DETAIL_URL + imdbId + jsonExtension

        jsonDetailData = makeRequest(urlByImdbId)
        return jsonParser.readDetailsJsonStream(jsonDetailData)
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

            jsonDetailData = response!!.body!!.string()
        } catch (e : IOException) {
            e.printStackTrace()
        }
        return jsonDetailData
    }
}