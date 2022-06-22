package com.bsimsek.moviekmmsample.viewstate

import com.bsimsek.moviekmmsample.data.model.remote.MovieResponse

data class MovieViewState(
    val isLoading: Boolean,
    val movieResponse: MovieResponse?,
    val error: Throwable?
) {

    companion object {
        val empty = MovieViewState(
            true,
            null,
            null
        )
        val mocked = MovieViewState(
            false,
            MovieResponse.mocked,
            null
        )
    }
}

fun MovieViewState.resetState(): MovieViewState {
    return this.copy(error = null)
}