package com.bsimsek.moviekmmsample.data.factory

import io.ktor.client.*

expect class ApiService() {
    fun build(): HttpClient
}