package com.jetbrains.weatherapp.network

import io.ktor.client.HttpClient
import com.jetbrains.weatherapp.weather.Weather
import com.jetbrains.weatherapp.Config

class WeatherApi {
    private val httpClient = HttpClient {
        //TODO Setup the HTTP client and install the plugins
    }

    suspend fun getWeather(lat: Double, long: Double): Weather {
        TODO() // Call the webservice and get the body
        "https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${long}&appid=${Config.WeatherApiKey}&units=metric"
    }
}