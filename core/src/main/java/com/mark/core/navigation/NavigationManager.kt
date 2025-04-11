package com.mark.core.navigation

import com.mark.core.navigation.Screen.CurrentWeather

fun CurrentWeather.withCity(city: String): String = "current_weather/$city"
fun Screen.ForcastWeather.withCity(city: String): String = "forcast_weather/$city"
