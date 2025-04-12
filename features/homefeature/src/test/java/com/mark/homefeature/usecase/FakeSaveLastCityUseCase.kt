package com.mark.homefeature.usecase

import com.mark.domain.cityInputDomain.usecase.ISaveLastCityUseCase

class FakeSaveLastCityUseCase : ISaveLastCityUseCase {
    var savedCity: String? = null
    override suspend fun execute(city: String) {
        savedCity = city
    }
}