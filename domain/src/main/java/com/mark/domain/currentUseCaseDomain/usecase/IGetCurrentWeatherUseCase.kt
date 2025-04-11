package com.mark.domain.currentUseCaseDomain.usecase

import com.mark.domain.currentUseCaseDomain.CurrentWeatherResult

import kotlinx.coroutines.flow.Flow

interface IGetCurrentWeatherUseCase {
    fun execute(city: String): Flow<CurrentWeatherResult>
}