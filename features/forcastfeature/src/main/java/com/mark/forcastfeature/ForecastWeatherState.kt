package com.mark.forcastfeature

import ForecastDay
import com.mark.domain.forcastDomain.response.Forecastday
import java.util.List

data class ForecastWeatherState(
     val city: String="",
    val temperature: String="",
    val precipitation: String="",
    val maxTemp: String="",
    val minTemp: String="",
    val days: List<Forecastday> ?=null,
    val isLoading : Boolean=false
)