package com.bsimsek.moviekmmsample.android.ui.main.nowplaying

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.bsimsek.moviekmmsample.android.ui.components.ErrorScreen
import com.bsimsek.moviekmmsample.android.ui.components.ScreenContainer
import com.bsimsek.moviekmmsample.android.ui.main.MovieContentScreen
import com.bsimsek.moviekmmsample.data.model.remote.asDomainMovieList

@Composable
fun NowPlayingScreen(
    onMovieClicked: (movieId: Long) -> Unit,
    viewModel: NowPlayingViewModel = hiltViewModel()
) {

    val state = viewModel.viewState.collectAsState().value

    ScreenContainer(
        loadingState = state.isLoading,
        onRefresh = viewModel::initState
    ) {
        state.movieResponse?.let {
            MovieContentScreen(
                movieList = it.movieList.asDomainMovieList(),
                onMovieClicked = onMovieClicked
            )
        }
        state.error?.let {
            ErrorScreen(message = it.message.toString()) {
                viewModel.initState()
            }
        }
    }
}