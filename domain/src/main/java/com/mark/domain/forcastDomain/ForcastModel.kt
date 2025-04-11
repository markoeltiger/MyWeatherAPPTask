package com.mark.domain.forcastDomain

import com.mark.domain.currentDomain.entities.CurrentWeatherModel
import com.mark.domain.currentDomain.response.CurrentWeatherResponse
import com.mark.domain.forcastDomain.entities.ForcasttWeatherModel
import com.mark.domain.forcastDomain.response.ForcastWeatherResponse


fun ForcastWeatherResponse.mapToForcastWeatherModel(): ForcasttWeatherModel {
    return ForcasttWeatherModel(
        location?.name.toString(),
        location?.country.toString(),
        location?.localtime.toString(),
        current?.tempC ?: 0.0,
        current?.feelslikeC ?: 0.0,
        current?.feelslikeF ?: 0.0,
        current?.condition?.text.toString(),
        current?.condition?.icon.toString(),
        current?.humidity ?: 0.0,
        current?.windMph ?: 0.0,
        forcast = forecast
    )
}


fun ForcastWeatherResponse.mapToForcastWeatherResult(): ForcasttWeatherResult {
    if (location.country.isNotEmpty() == true) {
        return ForcasttWeatherResult.SuccessResult(this.mapToForcastWeatherModel())
    } else {
        return ForcasttWeatherResult.ErrorResult("Error")
    }
}


sealed class ForcasttWeatherResult {
    data class SuccessResult(val forecastWeather: ForcasttWeatherModel) :
        ForcasttWeatherResult()

    data class ErrorResult(val msg: String?) : ForcasttWeatherResult()
}