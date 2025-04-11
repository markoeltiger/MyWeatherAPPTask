package com.mark.domain.currentUseCaseDomain.usecase


import com.mark.domain.currentUseCaseDomain.CurrentWeatherResult
import com.mark.domain.currentUseCaseDomain.mapToCurrentWeatherResult
import com.mark.domain.currentUseCaseDomain.repo.ICurrentWeatherRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetCurrentWeatherUseCase @Inject constructor(
        private val receiptRepo: ICurrentWeatherRepo
) : IGetCurrentWeatherUseCase {


    override fun execute(city: String): Flow<CurrentWeatherResult> {
        return receiptRepo.getCurrentWeather(city).map {
            it.mapToCurrentWeatherResult()
        }
    }
}