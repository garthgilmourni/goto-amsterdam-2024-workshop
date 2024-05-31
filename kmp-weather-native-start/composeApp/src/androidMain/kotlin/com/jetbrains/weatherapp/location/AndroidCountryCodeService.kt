package com.jetbrains.weatherapp.location

class AndroidCountryCodeService : CountryCodeService {
    override fun getCountryCode() = "FR"
}

actual fun getCountryCode(): CountryCodeService = AndroidCountryCodeService()