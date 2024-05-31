package com.jetbrains.weatherapp.location

import java.util.Locale

class DesktopCountryCodeService: CountryCodeService {
    override fun getCountryCode(): String? {
        return Locale.getDefault().country
    }
}
actual fun getCountryCode(): CountryCodeService = DesktopCountryCodeService()