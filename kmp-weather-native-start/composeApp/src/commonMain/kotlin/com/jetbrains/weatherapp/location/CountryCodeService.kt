package com.jetbrains.weatherapp.location

interface CountryCodeService {
    fun getCountryCode(): String?
}
expect fun getCountryCode(): CountryCodeService