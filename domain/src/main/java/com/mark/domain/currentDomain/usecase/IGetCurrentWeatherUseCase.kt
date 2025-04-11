package com.mark.domain.currentDomain.usecase

import com.mark.domain.currentDomain.CurrentWeatherResult

import kotlinx.coroutines.flow.Flow

interface IGetCurrentWeatherUseCase {
    fun execute(city: String): Flow<CurrentWeatherResult>
}