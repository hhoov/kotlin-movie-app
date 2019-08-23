package com.example.kotlin_movie_app.dagger

import android.os.Handler
import android.os.Looper
import com.example.kotlin_movie_app.util.UIExecutor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideOkhttpClient() : OkHttpClient { return OkHttpClient() }

    @Provides
    @Singleton
    fun provideUIExecutor() : UIExecutor { return UIExecutor(
        Handler(Looper.getMainLooper())
    )
    }

    @Provides
    @Singleton
    fun provideBackgroundExecutor(): Executor { return Executors.newFixedThreadPool(10) }

}