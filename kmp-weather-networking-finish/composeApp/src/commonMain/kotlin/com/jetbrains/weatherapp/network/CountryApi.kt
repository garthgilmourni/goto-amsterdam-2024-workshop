package com.jetbrains.weatherapp.network

import com.jetbrains.weatherapp.country.Country
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.http.fullPath
import io.ktor.http.headersOf
import io.ktor.serialization.kotlinx.json.json
import io.ktor.utils.io.ByteReadChannel
import kotlinx.serialization.json.Json
import org.jetbrains.compose.resources.InternalResourceApi
import org.jetbrains.compose.resources.readResourceBytes

class CountryApi {
    //If the 'restcountries' public API is causing timeouts then you
    // can use the commented out function to mock the call
    private val httpClient = HttpClient(/* buildMockEngine() */) {
        install(ContentNegotiation) {
            json(Json {
                encodeDefaults = true
                isLenient = true
                coerceInputValues = true
                ignoreUnknownKeys = true
            })
        }
    }

    suspend fun getAllCountries(): List<Country> {
        return httpClient.get("https://restcountries.com/v3.1/all").body()
    }
}

private fun buildMockEngine(): HttpClientEngine {
    fun emptyData() = ByteReadChannel("")
    fun jsonContent() = headersOf(HttpHeaders.ContentType, "application/json")
    @OptIn(InternalResourceApi::class)
    suspend fun sampleData(): ByteReadChannel {
        return  ByteReadChannel(readResourceBytes("files/allCountries.json"))
    }

    return MockEngine { request ->
        val pathMatches = request.url.fullPath.contains("all")
        val isGetRequest = request.method == HttpMethod.Get

        if (pathMatches && isGetRequest) {
            respond(sampleData(), HttpStatusCode.OK, jsonContent())
        } else {
            respond(emptyData(), HttpStatusCode.NotFound)
        }
    }
}
