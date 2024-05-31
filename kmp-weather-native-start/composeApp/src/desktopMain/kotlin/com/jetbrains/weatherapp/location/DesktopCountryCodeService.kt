package com.jetbrains.weatherapp.location

class DesktopCountryCodeService : CountryCodeService {
    override fun getCountryCode() = "FR"
}

actual fun getCountryCode(): CountryCodeService = DesktopCountryCodeService()