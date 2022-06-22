package com.bsimsek.moviekmmsample.data.source

import com.bsimsek.moviekmmsample.data.model.remote.MovieResponse
import kotlinx.coroutines.flow.Flow

interface MovieTestDataSource {
    fun fetchMovies(movieType: String): Flow<kotlin.Result<MovieResponse>>
}