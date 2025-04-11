package com.mark.data.forcastData.repo


import com.mark.data.BuildConfig
import com.mark.data.forcastData.api.ForcastWeatherApi
import com.mark.domain.currentDomain.repo.ICurrentWeatherRepo
import com.mark.domain.forcastDomain.repo.IForcastWeatherRepo
import com.mark.domain.forcastDomain.response.ForcastWeatherResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ForcastWeatherRepo @Inject constructor(
    private val api: ForcastWeatherApi,
) : IForcastWeatherRepo {
    override fun getForcastWeather(city: String): Flow<ForcastWeatherResponse> {
        val apiKey = BuildConfig.API_KEY
        return flow {
            emit(api.getForcastWeather(apiKey,city,DAYS))
        }
    }
}
const val DAYS = 7