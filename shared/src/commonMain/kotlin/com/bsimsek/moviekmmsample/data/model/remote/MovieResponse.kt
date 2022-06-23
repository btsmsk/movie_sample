package com.bsimsek.moviekmmsample.data.model.remote

import com.bsimsek.moviekmmsample.data.BaseResponseModel
import com.bsimsek.moviekmmsample.data.model.local.Movie
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieResponse(
    @SerialName("results") val movieList: List<MovieDataResponseModel>
) : BaseResponseModel() {

    /**To help SwiftUI*/
    val movieDataList: List<Movie> get() = movieList.asDomainMovieList()

    companion object {
        val mocked = MovieResponse(listOf(MovieDataResponseModel.mocked))
    }
}

fun List<MovieDataResponseModel>.asDomainMovieList(): List<Movie> {
    return map { it.asDomainModel() }
}
