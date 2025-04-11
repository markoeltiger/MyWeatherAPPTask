package com.mark.domain.cityInputDomain.usecase

import kotlinx.coroutines.flow.Flow

interface IGetLastCityUseCase {
    fun execute( ): Flow<String?>
}