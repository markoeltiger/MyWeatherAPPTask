package com.mark.domain.currentDomain.usecase


import com.mark.domain.currentDomain.CurrentWeatherResult
import com.mark.domain.currentDomain.mapToCurrentWeatherResult
import com.mark.domain.currentDomain.repo.ICurrentWeatherRepo
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