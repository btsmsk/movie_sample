package com.bsimsek.moviekmmsample.data.model.local

import com.bsimsek.moviekmmsample.AppKey

data class MovieCategory(
    val id: Int,
    val type: String,
    val name: String
) {
    constructor() : this(0, "", "")

    companion object {
        val nowPlaying =
            MovieCategory(id = 1, type = AppKey.NOW_PLAYING_MOVIES, name = "Now Playing")
        val upComing =
            MovieCategory(id = 2, type = AppKey.UPCOMING_MOVIES, name = "Upcoming")
        val movieCategories: List<MovieCategory> = listOf(upComing, nowPlaying)
    }
}