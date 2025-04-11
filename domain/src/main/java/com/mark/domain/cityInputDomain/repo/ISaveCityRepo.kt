package com.mark.domain.cityInputDomain.repo

import kotlinx.coroutines.flow.Flow

interface ISaveCityRepo {
    suspend fun saveCity(city: String)
      fun getLastCity(): Flow<String?>
}