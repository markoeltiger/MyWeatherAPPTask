package com.mark.homefeature.usecase

import com.mark.domain.cityInputDomain.usecase.IGetLastCityUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeGetLastCityUseCase(private val city: String? = null) : IGetLastCityUseCase {
    override fun execute(): Flow<String?> = flowOf(city)
}