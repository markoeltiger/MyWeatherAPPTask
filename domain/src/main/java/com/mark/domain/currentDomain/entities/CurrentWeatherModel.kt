package com.mark.domain.currentDomain.entities

data class CurrentWeatherModel (
    val city: String,
    val country: String,
    val localTime: String,
    val temperature: Double,
    val minTemperature: Double,
    val maxTemperature: Double,
    val condition: String,
    val iconUrl: String,
    val humidity: Double,
    val windSpeed: Double
)

