package com.mark.domain.cityInputDomain.usecase

import com.mark.domain.currentUseCaseDomain.CurrentWeatherResult

import kotlinx.coroutines.flow.Flow

interface IGetLastCityUseCase {
    fun execute( ): Flow<String?>
}