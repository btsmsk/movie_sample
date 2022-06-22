package com.bsimsek.moviekmmsample.data.source

import com.bsimsek.moviekmmsample.AppKey
import com.bsimsek.moviekmmsample.data.BaseRemoteDataSource
import com.bsimsek.moviekmmsample.data.model.remote.MovieResponse
import com.bsimsek.moviekmmsample.internal.util.ApiKey
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.coroutines.flow.Flow

class MovieRemoteDataSource(
    private val apiService: HttpClient
) : BaseRemoteDataSource() {

    suspend fun fetchMovies(movieType: String): Flow<Result<MovieResponse>> = invokeFlow {
        Result.success(apiService.get(urlString = "${AppKey.BASE_URL}$movieType") {
            contentType(ContentType.Application.Json)
            parameter("api_key", ApiKey().value)
        })
    }
}