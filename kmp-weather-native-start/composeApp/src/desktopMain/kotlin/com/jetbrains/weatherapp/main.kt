package com.jetbrains.weatherapp

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.jetbrains.weatherapp.App

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "WeatherApp") {
        App()
    }
}

@Preview
@Composable
fun AppDesktopPreview() {
    App()
}