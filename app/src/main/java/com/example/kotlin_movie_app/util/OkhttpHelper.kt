package com.example.kotlin_movie_app.util

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton


private const val MOVIE_URL = "https://raw.githubusercontent.com/MercuryIntermedia/Sample_Json_Movies/35cccb4bb96bc00575f34ab49bb0f56bf7c77f0e/top_movies.json"

@Singleton
class OkhttpHelper {
    private var jsonData : String = ""
    private lateinit var okHttpClient: OkHttpClient

    @Inject
    fun OkhttpHelper(okHttpClient: OkHttpClient) {
        this.okHttpClient = okHttpClient
    }

    fun provideOkhttpClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
        return client.build()
    }

    fun provideRetrofitClient(okHttpClient: OkHttpClient): String {
        return Retrofit.Builder()
            .baseUrl(MOVIE_URL)
            //.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
            .create(MOVIE_URL::class.java)
    }


    private fun makeRequest(url: String): String {
        try {
            val request = Request.Builder()
                .url(url)
                .build()
            var response: Response? = null

            try {
                response = okHttpClient.newCall(request).execute()
            } catch (e: IOException) {
                e.printStackTrace()
            }

            jsonData = response?.body.toString()

        } catch (e: IOException) {
            e.printStackTrace()
        }

        return jsonData

    }
}