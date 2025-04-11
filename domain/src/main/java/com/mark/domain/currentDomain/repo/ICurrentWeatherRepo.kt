package com.mark.domain.currentDomain.repo

import com.mark.domain.currentDomain.response.CurrentWeatherResponse
import kotlinx.coroutines.flow.Flow

interface ICurrentWeatherRepo {
    fun getCurrentWeather(city:String): Flow<CurrentWeatherResponse>

}