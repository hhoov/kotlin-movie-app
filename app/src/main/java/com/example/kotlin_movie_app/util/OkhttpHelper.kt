package com.example.kotlin_movie_app.util

import androidx.appcompat.app.AppCompatActivity
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.io.IOException
import java.io.InputStream


private const val MOVIE_URL = "https://raw.githubusercontent.com/MercuryIntermedia/Sample_Json_Movies/35cccb4bb96bc00575f34ab49bb0f56bf7c77f0e/top_movies.json"

abstract class OkhttpHelper : AppCompatActivity()
{
    //private val okHttpClient: OkHttpClient()

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
}

    fun makeRequest(url: String): InputStream {
        var jsonData = ""
        try {
            /*val request = Retrofit.Builder()
                .baseUrl(url)
                .build()*/

           // var response: Response? = null
            try {
               // response = okHttpClient.newCall(request).execute()
            } catch (e: IOException) {
                e.printStackTrace()
            }

           // jsonData = response!!.body().string()

        } catch (e: IOException) {
            e.printStackTrace()
        }

        return jsonData.byteInputStream()


}