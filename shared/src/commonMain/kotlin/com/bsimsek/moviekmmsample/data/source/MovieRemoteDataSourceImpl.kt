package com.bsimsek.moviekmmsample.data.source

import com.bsimsek.moviekmmsample.AppKey
import com.bsimsek.moviekmmsample.data.model.remote.MovieResponse
import com.bsimsek.moviekmmsample.internal.util.ApiKey
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class MovieRemoteDataSourceImpl(private val apiService: HttpClient) : MovieRemoteDataSource {
    override fun fetchMovies(movieType: String): Flow<Result<MovieResponse>> = flow {
        val response =
            apiService.get<MovieResponse>(urlString = "${AppKey.BASE_URL}$movieType") {
                contentType(ContentType.Application.Json)
                parameter("api_key", ApiKey().value)
            }
        emit(Result.success(response))
    }.catch { e -> emit(Result.failure(e)) }
}