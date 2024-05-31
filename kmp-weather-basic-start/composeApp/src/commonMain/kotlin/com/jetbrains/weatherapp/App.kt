package com.jetbrains.weatherapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jetbrains.weatherapp.country.Country
import com.jetbrains.weatherapp.country.Flags
import com.jetbrains.weatherapp.country.Name
import com.jetbrains.weatherapp.country.countries

@Composable
fun App() {
    MaterialTheme {
        Surface {
            LazyColumn() {
                items(items = countries) {
                    CountryCard(modifier = Modifier, country = it)
                }
            }
        }
    }
}

@Composable
fun CountryCard(modifier: Modifier, country: Country) {
    Card(
        modifier = modifier.fillMaxWidth().padding(4.dp),
        elevation = 10.dp,
        shape = MaterialTheme.shapes.medium
    ) {
        Row(modifier = Modifier.fillMaxSize().padding(8.dp)) {
            Column(modifier = Modifier.width(130.dp).height(128.dp)) {
                Flag(modifier = Modifier.fillMaxWidth().padding(8.dp), country.flags)
            }
            Column(modifier = Modifier.fillMaxWidth().height(128.dp).padding(8.dp)) {
                CountryNames(name = country.name)
                WeatherButtons(capitals = country.capital)
            }
        }
    }
}

@Composable
fun Flag(modifier: Modifier = Modifier, flag: Flags) {
    //TODO Create a card and add an image pointing to the flag png url
    Text("Your content here - A")
}

@Composable
fun CountryNames(modifier: Modifier = Modifier, name: Name) {
    // TODO Create a layout and add two texts under each other
    // Line 1: style is body1, text is name.common
    // Line 2: style is body2, text is name.official
    Text("Your content here - B")
}

@Composable
fun WeatherButtons(modifier: Modifier = Modifier, capitals: List<String>) {
    //TODO Create a layout and add all the capital buttons under each other
    Text("Your content here - C")
}
