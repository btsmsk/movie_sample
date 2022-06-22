package com.bsimsek.moviekmmsample.data.model.remote

import com.bsimsek.moviekmmsample.data.BaseResponseModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieDataResponseModel(
    @SerialName("id") val id: Long,
    @SerialName("title") val title: String,
    @SerialName("overview") val overview: String,
    @SerialName("genre_ids") val genreIds: List<Long>,
    @SerialName("poster_path")
    val posterPath: String?,
    @SerialName("backdrop_path")
    val backdropPath: String?,
    @SerialName("popularity") val popularity: Double,
    @SerialName("vote_average") val average: Double,
    @SerialName("adult") val isAdult: Boolean,
    @SerialName("release_date") val releaseDate: String
) : BaseResponseModel()
