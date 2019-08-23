package com.example.kotlin_movie_app

import android.app.Application
import com.example.kotlin_movie_app.dagger.AppModule
import com.example.kotlin_movie_app.dagger.AppComponent
import com.example.kotlin_movie_app.dagger.DaggerAppComponent

class MovieApplication : Application() {

    lateinit var appComponent: AppComponent
    private set

    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule())
            .build()
    }

    companion object {
        lateinit var instance: MovieApplication

        fun instance(): MovieApplication {
            return instance
        }
    }
}