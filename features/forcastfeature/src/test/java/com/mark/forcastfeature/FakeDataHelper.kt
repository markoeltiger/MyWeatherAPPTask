package com.mark.forcastfeature

import com.mark.domain.forcastDomain.entities.ForcasttWeatherModel
import com.mark.domain.forcastDomain.response.Forecast

fun fakeForecastWeather(): ForcasttWeatherModel {
    return ForcasttWeatherModel(
        city = "Cairo",
        country = "Egypt",
        localTime = "2025-04-11 12:00",
        temperature = 28.5,
        minTemperature = 20.0,
        maxTemperature = 32.0,
        condition = "Clear Sky",
        iconUrl = "//cdn.weatherapi.com/weather/64x64/day/113.png",
        humidity = 60,
        windSpeed = 15.0,
        uvIndex = "5",
        forcast = Forecast(null
        ))}
