package com.mark.domain.currentDomain.entities

data class CurrentWeatherEntity (
    val city: String,
    val country: String,
    val localTime: String,
    val temperature: Double,
    val condition: String,
    val iconUrl: String,
    val humidity: Int,
    val windSpeed: Double
)