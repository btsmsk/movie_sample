package com.bsimsek.moviekmmsample.data.repo

import com.bsimsek.moviekmmsample.data.model.remote.MovieResponse
import com.bsimsek.moviekmmsample.data.source.MovieRemoteDataSource
import kotlinx.coroutines.flow.Flow

class MovieRepository(
    private val remoteDataSource: MovieRemoteDataSource,
) {
    suspend fun fetchMovies(movieType: String): Flow<Result<MovieResponse>> {
        return remoteDataSource.fetchMovies(movieType)
    }
}
