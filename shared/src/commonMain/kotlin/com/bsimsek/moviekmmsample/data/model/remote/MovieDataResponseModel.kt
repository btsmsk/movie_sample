package com.bsimsek.moviekmmsample.data.model.remote

import com.bsimsek.moviekmmsample.data.BaseResponseModel
import com.bsimsek.moviekmmsample.data.model.local.Movie
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieDataResponseModel(
    @SerialName("id") val id: Long,
    @SerialName("original_title") val originalTitle: String,
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
) : BaseResponseModel() {
    companion object {
        val mocked =
            MovieDataResponseModel(
                1L,
                "title",
                "overview",
                listOf(12),
                "path",
                "backdropPath",
                14.0,
                44.4,
                false,
                "21-21-2022"
            )
    }
}

/** Convert remote response to [Model] Domain objects*/
fun MovieDataResponseModel.asDomainModel(): Movie {
    return Movie(
        movieId = id,
        originalTitle = originalTitle,
        overview = overview,
        posterPath = posterPath ?: "",
        releaseDate = releaseDate
    )
}
