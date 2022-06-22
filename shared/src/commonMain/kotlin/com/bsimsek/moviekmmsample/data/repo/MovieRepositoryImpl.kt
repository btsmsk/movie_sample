package com.bsimsek.moviekmmsample.data.repo

import com.bsimsek.moviekmmsample.data.model.remote.MovieResponse
import com.bsimsek.moviekmmsample.data.source.MovieRemoteDataSource
import kotlinx.coroutines.flow.Flow

class MovieRepositoryImpl(
    private val remoteDataSource: MovieRemoteDataSource
) : MovieRepository {
    override fun fetchMovies(movieType: String): Flow<Result<MovieResponse>> {
        return remoteDataSource.fetchMovies(movieType)
    }
}