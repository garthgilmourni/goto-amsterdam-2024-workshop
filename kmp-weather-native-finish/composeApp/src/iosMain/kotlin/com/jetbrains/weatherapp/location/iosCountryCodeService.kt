package com.jetbrains.weatherapp.location

import platform.Foundation.*

class IOSCountryCodeService: CountryCodeService {
    override fun getCountryCode(): String? {
        return NSLocale.currentLocale().objectForKey(NSLocaleCountryCode).toString()
    }
}

actual fun getCountryCode(): CountryCodeService = IOSCountryCodeService()