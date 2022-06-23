package com.bsimsek.moviekmmsample.android.ui.main.upcoming

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.bsimsek.moviekmmsample.android.ui.components.ScreenContainer

@Composable
fun UpComingScreen(
    onMovieClicked: (movieId: Long) -> Unit,
) {
    ScreenContainer(
        loadingState = false,
        onRefresh = {},
    ) {
        Text(text = "Upcoming", color = Color.White, fontSize = 30.sp)
    }
}