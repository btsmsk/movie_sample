package com.bsimsek.moviekmmsample.android.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bsimsek.moviekmmsample.android.ui.main.MainScreen

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController()
) {
    val action = remember(navController) { AppAction(navController) }
    NavHost(navController = navController, startDestination = AppDestination.mainScreen) {
        composable(AppDestination.mainScreen) {
            MainScreen(
                onMovieClicked = action.navigateToDetail
            )
        }
    }
}