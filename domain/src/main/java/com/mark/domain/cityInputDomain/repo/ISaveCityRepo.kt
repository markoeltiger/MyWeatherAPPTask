package com.mark.domain.cityInputDomain.repo

import dagger.hilt.InstallIn
import kotlinx.coroutines.flow.Flow

interface ISaveCityRepo {
    suspend fun saveCity(city: String)
      fun getLastCity(): Flow<String?>
}