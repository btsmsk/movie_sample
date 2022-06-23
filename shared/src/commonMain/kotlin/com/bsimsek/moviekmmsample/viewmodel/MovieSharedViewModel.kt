package com.bsimsek.moviekmmsample.viewmodel

import com.bsimsek.moviekmmsample.AppKey
import com.bsimsek.moviekmmsample.data.model.local.MovieCategory
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
            MovieCategory.nowPlaying.id -> MovieCategory.nowPlaying.type
            MovieCategory.upComing.id -> MovieCategory.upComing.type
            else -> AppKey.TOP_RATED_MOVIES
        }
    }
}