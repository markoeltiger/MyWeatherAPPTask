package com.mark.forcastfeature

sealed class ForecastIntent {
    data class LoadForecast(val city: String) : ForecastIntent()
    object RefreshForecast : ForecastIntent()
 }