package com.bsimsek.moviekmmsample.android.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshState

@Composable
fun ScreenContainer(
    modifier: Modifier = Modifier,
    loadingState: Boolean,
    onRefresh: () -> Unit,
    appBarBackgroundColor: Color = MaterialTheme.colors.primary,
    appBarContentColor: Color = MaterialTheme.colors.onPrimary,
    barTitle: String? = null,
    leadingIcon: Int? = null,
    trailingIcon: Int? = null,
    onLeadingIconClicked: (() -> Unit)? = null,
    onTrailingIconClicked: (() -> Unit)? = null,
    content: @Composable () -> Unit,
) {

    SwipeRefresh(
        state = SwipeRefreshState(loadingState),
        onRefresh = onRefresh,
        modifier = modifier
    ) {
        Scaffold(
            topBar = {
                barTitle?.let {
                    AppBar(
                        barTitle = barTitle,
                        appBarBackground = appBarBackgroundColor,
                        appBarContentColor = appBarContentColor,
                        leadingIcon = leadingIcon,
                        trailingIcon = trailingIcon,
                        onLeadingIconClicked = onLeadingIconClicked,
                        onTrailingIconClicked = onTrailingIconClicked
                    )
                }
            },
            content = { content() }
        )
    }

}