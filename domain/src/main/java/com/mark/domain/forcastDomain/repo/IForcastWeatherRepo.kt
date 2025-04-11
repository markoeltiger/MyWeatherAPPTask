package com.mark.domain.forcastDomain.repo

import com.mark.domain.currentDomain.response.CurrentWeatherResponse
import com.mark.domain.forcastDomain.response.ForcastWeatherResponse
import kotlinx.coroutines.flow.Flow

interface IForcastWeatherRepo {
    fun getForcastWeather(city:String): Flow<ForcastWeatherResponse>

}