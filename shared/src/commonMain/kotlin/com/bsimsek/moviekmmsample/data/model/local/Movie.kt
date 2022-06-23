package com.bsimsek.moviekmmsample.data.model.local

import com.bsimsek.moviekmmsample.data.model.remote.MovieDataResponseModel
import com.bsimsek.moviekmmsample.data.model.remote.asDomainModel

data class Movie(
    val posterPath: String,
    val overview: String,
    val releaseDate: String,
    val movieId: Long,
    val originalTitle: String,
) {
    val poster = "https://image.tmdb.org/t/p/w300/$posterPath"
    companion object {
        val mocked = MovieDataResponseModel.mocked.asDomainModel()
    }
}