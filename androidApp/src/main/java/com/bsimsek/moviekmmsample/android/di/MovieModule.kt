package com.bsimsek.moviekmmsample.android.di

import com.bsimsek.moviekmmsample.data.repo.MovieRepository
import com.bsimsek.moviekmmsample.data.repo.MovieRepositoryImpl
import com.bsimsek.moviekmmsample.data.source.MovieRemoteDataSource
import com.bsimsek.moviekmmsample.data.source.MovieRemoteDataSourceImpl
import com.bsimsek.moviekmmsample.usecase.fetchMovies.FetchMoviesUseCase
import com.bsimsek.moviekmmsample.usecase.fetchMovies.FetchMoviesUseCaseImpl
import com.bsimsek.moviekmmsample.viewmodel.MovieSharedViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieModule {

    @Singleton
    @Provides
    fun provideRemoteSource(apiService: HttpClient): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(apiService)
    }

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(movieRemoteDataSource)
    }

    @Singleton
    @Provides
    fun provideFetchMovieUseCase(movieRepository: MovieRepository): FetchMoviesUseCase {
        return FetchMoviesUseCaseImpl(movieRepository)
    }

    @Singleton
    @Provides
    fun provideMovieSharedViewModel(fetchMovies: FetchMoviesUseCase): MovieSharedViewModel {
        return MovieSharedViewModel(fetchMovies)
    }
}