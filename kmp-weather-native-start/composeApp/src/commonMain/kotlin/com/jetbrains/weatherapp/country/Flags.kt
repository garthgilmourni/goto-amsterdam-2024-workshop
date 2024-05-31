package com.jetbrains.weatherapp.country

import kotlinx.serialization.Serializable

@Serializable
data class Flags(
    val alt: String = "",
    val png: String,
    val svg: String
)