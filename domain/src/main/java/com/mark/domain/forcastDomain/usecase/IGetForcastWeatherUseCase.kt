package com.mark.domain.forcastDomain.usecase

import com.mark.domain.currentDomain.CurrentWeatherResult
import com.mark.domain.forcastDomain.ForcasttWeatherResult

import kotlinx.coroutines.flow.Flow

interface IGetForcastWeatherUseCase {
    fun execute(city: String): Flow<ForcasttWeatherResult>
}