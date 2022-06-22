package com.bsimsek.moviekmmsample.data.repo

import com.bsimsek.moviekmmsample.data.model.remote.MovieResponse
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun fetchMovies(movieType: String): Flow<Result<MovieResponse>>
}