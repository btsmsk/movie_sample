package com.bsimsek.moviekmmsample.android.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.bsimsek.moviekmmsample.android.R
import com.bsimsek.moviekmmsample.android.ui.components.AppBar
import com.bsimsek.moviekmmsample.android.ui.navigation.Tabs
import com.bsimsek.moviekmmsample.android.ui.navigation.TabsContent
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalMaterialApi::class, ExperimentalPagerApi::class)
@Composable
fun MainScreen(
    onMovieClicked: (movieId: Long) -> Unit
) {
    val tabs = listOf(TabItem.NowPlaying, TabItem.Upcoming)
    val pagerState = rememberPagerState(0)
    Scaffold(
        topBar = {
            AppBar(
                barTitle = stringResource(R.string.AppName),
                appBarBackground = MaterialTheme.colors.primary,
                appBarContentColor = MaterialTheme.colors.onPrimary
            )
        }
    ) {
        Column {
            Tabs(tabs = tabs, pagerState = pagerState)
            TabsContent(tabs = tabs, pagerState = pagerState, onMovieClicked = onMovieClicked)
        }
    }
}