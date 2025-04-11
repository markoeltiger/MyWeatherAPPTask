package com.mark.data.homeDomain.repo


import com.mark.data.BuildConfig
import com.mark.data.currentWeatherData.api.CurrentWeatherApi
import com.mark.data.homeDomain.dataSource.CityPreferenceDataSource
import com.mark.domain.cityInputDomain.repo.ISaveCityRepo
import com.mark.domain.currentUseCaseDomain.repo.ICurrentWeatherRepo
import com.mark.domain.currentUseCaseDomain.response.CurrentWeatherResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CityRepositoryImpl @Inject constructor(
    private val dataSource: CityPreferenceDataSource
) : ISaveCityRepo {


    override suspend fun saveCity(city: String) = dataSource.saveCity(city)
    override fun getLastCity(): Flow<String?> {
         return dataSource.getLastCity
    }

 }