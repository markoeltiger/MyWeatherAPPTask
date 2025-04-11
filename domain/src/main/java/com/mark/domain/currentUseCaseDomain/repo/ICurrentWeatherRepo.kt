package com.mark.domain.currentUseCaseDomain.repo

import com.mark.domain.currentUseCaseDomain.response.CurrentWeatherResponse
import kotlinx.coroutines.flow.Flow

interface ICurrentWeatherRepo {
    fun getCurrentWeather(city:String): Flow<CurrentWeatherResponse>

}