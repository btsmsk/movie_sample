package com.bsimsek.moviekmmsample.android.ui.main

import androidx.compose.runtime.Composable
import com.bsimsek.moviekmmsample.android.ui.main.nowplaying.NowPlayingScreen
import com.bsimsek.moviekmmsample.android.ui.main.upcoming.UpComingScreen

/**
 * Created by Annas Surdyanto on 18/11/21.
 *
 */
sealed class TabItem(
    var title: String,
    var screen: @Composable (onMovieClicked: (movieId: Long) -> Unit) -> Unit
) {

    object Upcoming :
        TabItem("Upcoming", { onMovieClicked -> UpComingScreen(onMovieClicked = onMovieClicked) })

    object NowPlaying :
        TabItem("Playing", { onMovieClicked -> NowPlayingScreen(onMovieClicked = onMovieClicked) })
}