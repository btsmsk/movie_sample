package com.bsimsek.moviekmmsample.usecase.fetchMovies

import com.bsimsek.moviekmmsample.data.model.remote.MovieResponse
import com.bsimsek.moviekmmsample.data.repo.MovieRepository
import kotlinx.coroutines.flow.Flow

class FetchMoviesImpl(private val movieRepository: MovieRepository) : FetchMovies {
    override fun invoke(movieType: String): Flow<Result<MovieResponse>> {
        return movieRepository.fetchMovies(movieType)
    }
}