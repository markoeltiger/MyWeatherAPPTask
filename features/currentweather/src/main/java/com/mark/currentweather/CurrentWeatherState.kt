package com.mark.currentweather

data class CurrentWeatherState(
    val city: String,
    val temperature: String,
    val precipitation: String,
    val icon: String,
    val maxTemp: String,
    val minTemp: String,
    val condition: String,
    val humadity: String,
    val sunRise: String,
    val uvIndex: String,
    val windSpeed: String,

)