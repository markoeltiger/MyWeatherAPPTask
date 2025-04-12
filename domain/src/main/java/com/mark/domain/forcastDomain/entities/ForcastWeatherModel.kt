package com.mark.domain.forcastDomain.entities

import com.mark.domain.forcastDomain.response.Forecast

data class ForcasttWeatherModel (
    val city: String,
    val country: String,
    val localTime: String,
    val temperature: Double,
    val minTemperature: Double,
    val maxTemperature: Double,
    val condition: String,
    val iconUrl: String,
    val humidity: Any,
    val windSpeed: Double,
    val forcast: Forecast
)

