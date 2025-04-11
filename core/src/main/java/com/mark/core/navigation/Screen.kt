package com.mark.core.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object CurrentWeather : Screen("current_weather")
}