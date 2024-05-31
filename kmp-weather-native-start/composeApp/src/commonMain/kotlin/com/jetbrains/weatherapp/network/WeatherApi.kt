package com.jetbrains.weatherapp.network

import com.jetbrains.weatherapp.weather.Weather
import com.myapplication.Config
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class WeatherApi {
    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                encodeDefaults = true
                isLenient = true
                coerceInputValues = true
                ignoreUnknownKeys = true
            })
        }
    }

    suspend fun getWeather(lat: Double, long: Double): Weather {
        return httpClient.get("https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${long}&appid=${Config.WeatherApiKey}&units=metric")
            .body()
    }
}