package com.bsimsek.moviekmmsample.data.model.local

import com.bsimsek.moviekmmsample.AppKey

/**
 * Created by Annas Surdyanto on 15/11/21.
 *
 */
data class MovieCategory(
    val id: Int,
    val type: String,
    val name: String
) {
    constructor() : this(0, "", "")

    companion object {
        val upComing =
            MovieCategory(id = 2, type = AppKey.UPCOMING_MOVIES, name = "UpComing")
        val nowPlaying =
            MovieCategory(id = 4, type = AppKey.NOW_PLAYING_MOVIES, name = "Now Playing")
        val movieCategory: List<MovieCategory> = listOf(upComing, nowPlaying)
    }
}