package com.mark.domain.cityInputDomain.usecase

import com.mark.domain.currentUseCaseDomain.CurrentWeatherResult

import kotlinx.coroutines.flow.Flow

interface ISaveLastCityUseCase {
   suspend fun execute(city: String)
}