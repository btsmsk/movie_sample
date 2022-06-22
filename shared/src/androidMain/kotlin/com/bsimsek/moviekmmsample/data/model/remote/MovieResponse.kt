package com.bsimsek.moviekmmsample.data.model.remote

import com.bsimsek.moviekmmsample.data.BaseResponseModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieResponse(
    @SerialName("results") val movieList: List<MovieDataResponseModel>
) : BaseResponseModel()
