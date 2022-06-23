package com.bsimsek.moviekmmsample.viewmodel

import com.bsimsek.moviekmmsample.AppKey
import com.bsimsek.moviekmmsample.internal.util.CommonFlow
import com.bsimsek.moviekmmsample.internal.util.asCommonFlow
import com.bsimsek.moviekmmsample.usecase.fetchMovies.FetchMoviesUseCase
import com.bsimsek.moviekmmsample.viewstate.MovieViewState
import com.bsimsek.moviekmmsample.viewstate.resetState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

class MovieSharedViewModel(
    private val fetchMoviesUseCase: FetchMoviesUseCase
) {

    fun fetchMovie(viewState: MovieViewState, type: Int): CommonFlow<MovieViewState> = flow {
        val newState = viewState.resetState()
        emit(newState.copy(isLoading = true))
        fetchMoviesUseCase.invoke(getUrl(type)).collect {
            val stateToEmit = newState.copy(
                isLoading = false,
                movieResponse = it.getOrDefault(viewState.movieResponse),
                error = it.exceptionOrNull()
            )
            emit(stateToEmit)
        }
    }.asCommonFlow()

    private fun getUrl(type: Int): String {
        return when (type) {
            1 -> AppKey.POPULAR_MOVIES
            2 -> AppKey.NOW_PLAYING_MOVIES
            3 -> AppKey.UPCOMING_MOVIES
            else -> AppKey.TOP_RATED_MOVIES
        }
    }
}