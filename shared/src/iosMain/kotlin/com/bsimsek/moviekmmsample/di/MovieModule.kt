package com.bsimsek.moviekmmsample.di

import com.bsimsek.moviekmmsample.data.repo.MovieRepository
import com.bsimsek.moviekmmsample.data.repo.MovieRepositoryImpl
import com.bsimsek.moviekmmsample.data.source.MovieRemoteDataSource
import com.bsimsek.moviekmmsample.data.source.MovieRemoteDataSourceImpl
import com.bsimsek.moviekmmsample.usecase.fetchMovies.FetchMovies
import com.bsimsek.moviekmmsample.usecase.fetchMovies.FetchMoviesImpl

class MovieModule {

    private val appModule = AppModule()

    private val remoteSource: MovieRemoteDataSource by lazy {
        MovieRemoteDataSourceImpl(apiService = appModule.apiService)
    }

    private val movieRepository: MovieRepository by lazy {
        MovieRepositoryImpl(remoteDataSource = remoteSource)
    }

    private val fetchMovies: FetchMovies by lazy {
        FetchMoviesImpl(movieRepository)
    }

}