package com.mark.currentweather

data class CurrentWeatherState(
    val city: String,
    val temperature: String,
    val precipitation: String,
    val icon: String,
    val maxTemp: String,
    val minTemp: String,
)