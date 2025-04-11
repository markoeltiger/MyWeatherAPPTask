package com.mark.domain.forcastDomain.usecase


import com.mark.domain.currentDomain.CurrentWeatherResult
import com.mark.domain.currentDomain.mapToCurrentWeatherResult
import com.mark.domain.currentDomain.repo.ICurrentWeatherRepo
import com.mark.domain.forcastDomain.ForcasttWeatherResult
import com.mark.domain.forcastDomain.mapToForcastWeatherResult
import com.mark.domain.forcastDomain.repo.IForcastWeatherRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetForcastWeatherUseCase @Inject constructor(
        private val forcasttRepo: IForcastWeatherRepo
) : IGetForcastWeatherUseCase {


    override fun execute(city: String): Flow<ForcasttWeatherResult> {
        return forcasttRepo.getForcastWeather(city).map {
            it.mapToForcastWeatherResult()
        }
    }
}