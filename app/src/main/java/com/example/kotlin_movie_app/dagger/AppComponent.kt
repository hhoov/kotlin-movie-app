package com.example.kotlin_movie_app.dagger

import com.example.kotlin_movie_app.MoviesActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(moviesActivity: MoviesActivity)
}
