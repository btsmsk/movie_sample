package com.bsimsek.moviekmmsample.usecase.fetchMovies

import com.bsimsek.moviekmmsample.data.model.remote.MovieResponse
import kotlinx.coroutines.flow.Flow

interface FetchMoviesUseCase {
    operator fun invoke(movieType: String): Flow<Result<MovieResponse>>
}