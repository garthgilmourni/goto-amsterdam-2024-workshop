package com.jetbrains.weatherapp.country

val countries = listOf<Country>(
    Country(
        capital = listOf("Copenhagen"),
        capitalInfo = CapitalInfo(listOf(55.67,12.56)),
        flags = Flags(
            alt = "The flag of Denmark has a red field with a large white cross that extend to the edges of the field. The vertical part of this cross is offset towards the hoist side.",
            png = "https://flagcdn.com/w320/dk.png",
            svg = "https://flagcdn.com/de.svg"
        ),
        name = Name(common = "Denmark", official = "Kingdom of Denmark")
    ),
    Country(
        capital = listOf("Pretoria"),
        capitalInfo = CapitalInfo(listOf(-25.7,28.22)),
        flags = Flags(
            alt = "The flag of South Africa is composed of two equal horizontal bands of red and blue, with a yellow-edged black isosceles triangle superimposed on the hoist side of the field. This triangle has its base centered on the hoist end, spans about two-fifth the width and two-third the height of the field, and is enclosed on its sides by the arms of a white-edged green horizontally oriented Y-shaped band which extends along the boundary of the red and blue bands to the fly end of the field.",
            png = "https://flagcdn.com/w320/za.png",
            svg = "https://flagcdn.com/za.svg"
        ),
        name = Name(common = "South Africa", official = "Republic of South Africa")
    )
)
