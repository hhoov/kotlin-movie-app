package com.example.kotlin_movie_app.dagger

import com.example.kotlin_movie_app.ui.MoviesActivity
import com.example.kotlin_movie_app.data.MovieProvider
import com.example.kotlin_movie_app.ui.MovieBrowseFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(moviesActivity: MoviesActivity)
    fun inject(movieProvider: MovieProvider)
    fun inject(movieBrowseFragment: MovieBrowseFragment)
}
