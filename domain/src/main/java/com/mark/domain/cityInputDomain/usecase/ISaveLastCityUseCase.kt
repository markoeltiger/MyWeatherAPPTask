package com.mark.domain.cityInputDomain.usecase

interface ISaveLastCityUseCase {
   suspend fun execute(city: String)
}