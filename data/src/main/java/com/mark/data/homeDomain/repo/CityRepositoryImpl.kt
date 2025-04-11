package com.mark.data.homeDomain.repo


import com.mark.data.homeDomain.dataSource.CityPreferenceDataSource
import com.mark.domain.cityInputDomain.repo.ISaveCityRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CityRepositoryImpl @Inject constructor(
    private val dataSource: CityPreferenceDataSource
) : ISaveCityRepo {


    override suspend fun saveCity(city: String) = dataSource.saveCity(city)
    override fun getLastCity(): Flow<String?> {
         return dataSource.getLastCity
    }

 }