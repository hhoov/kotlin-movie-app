package com.example.kotlin_movie_app.dagger

import com.example.kotlin_movie_app.data.MovieDetailsProvider
import com.example.kotlin_movie_app.ui.MoviesActivity
import com.example.kotlin_movie_app.data.MovieProvider
import com.example.kotlin_movie_app.ui.MovieBrowseFragment
import com.example.kotlin_movie_app.ui.MovieDetailsActivity
import com.example.kotlin_movie_app.ui.MovieDetailsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(moviesActivity: MoviesActivity)
    fun inject(movieProvider: MovieProvider)
    fun inject(movieBrowseFragment: MovieBrowseFragment)
    fun inject(movieDetailsActivity: MovieDetailsActivity)
    fun inject(movieDetailsProvider: MovieDetailsProvider)
    fun inject(movieDetailsFragment: MovieDetailsFragment)
}
