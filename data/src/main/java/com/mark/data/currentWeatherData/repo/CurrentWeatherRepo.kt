package com.mark.data.currentWeatherData.repo


import com.mark.data.BuildConfig
import com.mark.data.currentWeatherData.api.CurrentWeatherApi
import com.mark.domain.currentUseCaseDomain.repo.ICurrentWeatherRepo
import com.mark.domain.currentUseCaseDomain.response.CurrentWeatherResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CurrentWeatherRepo @Inject constructor(
    private val api: CurrentWeatherApi,
) : ICurrentWeatherRepo {
    override fun getCurrentWeather(city: String): Flow<CurrentWeatherResponse> {
        val apiKey = BuildConfig.API_KEY
        return flow {
            emit(api.getCurrentWeather(apiKey,city))
        }    }
}