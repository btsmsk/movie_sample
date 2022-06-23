package com.bsimsek.moviekmmsample.android.ui.main

import androidx.compose.runtime.Composable
import com.bsimsek.moviekmmsample.android.ui.main.nowplaying.NowPlayingScreen
import com.bsimsek.moviekmmsample.android.ui.main.upcoming.UpComingScreen
import com.bsimsek.moviekmmsample.data.model.local.MovieCategory

sealed class TabItem(
    var title: String,
    var screen: @Composable (onMovieClicked: (movieId: Long) -> Unit) -> Unit
) {

    object Upcoming :
        TabItem(MovieCategory.upComing.name, { onMovieClicked -> UpComingScreen(onMovieClicked = onMovieClicked) })

    object NowPlaying :
        TabItem(MovieCategory.nowPlaying.name, { onMovieClicked -> NowPlayingScreen(onMovieClicked = onMovieClicked) })
}