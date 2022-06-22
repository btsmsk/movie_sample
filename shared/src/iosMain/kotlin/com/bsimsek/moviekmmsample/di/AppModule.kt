package com.bsimsek.moviekmmsample.di

import com.bsimsek.moviekmmsample.data.factory.ApiService
import io.ktor.client.*

class AppModule {
    val apiService: HttpClient by lazy {
        ApiService().build()
    }
}