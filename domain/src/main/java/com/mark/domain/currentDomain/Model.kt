package com.mark.domain.currentDomain

import com.mark.domain.currentDomain.entities.CurrentWeatherModel
import com.mark.domain.currentDomain.response.CurrentWeatherResponse


fun CurrentWeatherResponse.mapToCurrentWeatherModel(): CurrentWeatherModel {
    return CurrentWeatherModel(
        location?.name.toString(),
        location?.country.toString(),
        location?.localtime.toString(),
        current?.tempC ?: 0.0,
        current?.feelslikeC ?: 0.0,
        current?.feelslikeF ?: 0.0,
        current?.condition?.text.toString(),
        current?.condition?.icon.toString(),
        current?.humidity ?: 0.0,
        current?.windMph ?: 0.0

    )
}


fun CurrentWeatherResponse.mapToCurrentWeatherResult(): CurrentWeatherResult {
    if (location?.country?.isNotEmpty() == true) {
        return CurrentWeatherResult.SuccessResult(this.mapToCurrentWeatherModel())
    } else {
        return CurrentWeatherResult.ErrorResult("Error")
    }
}


sealed class CurrentWeatherResult {
    data class SuccessResult(val currentWeather: CurrentWeatherModel) :
        CurrentWeatherResult()

    data class ErrorResult(val msg: String?) : CurrentWeatherResult()
}