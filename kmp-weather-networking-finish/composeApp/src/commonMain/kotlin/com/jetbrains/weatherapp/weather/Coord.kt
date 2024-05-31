package com.jetbrains.weatherapp.weather

import kotlinx.serialization.Serializable

@Serializable
data class Coord(
    val lat: Double,
    val lon: Double
)