package com.jetbrains.weatherapp.location

class IOSCountryCodeService : CountryCodeService {
    override fun getCountryCode() = "FR"
}

actual fun getCountryCode(): CountryCodeService = IOSCountryCodeService()