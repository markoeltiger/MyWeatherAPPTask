package com.mark.domain.cityInputDomain.usecase


import com.mark.domain.cityInputDomain.repo.ISaveCityRepo
import javax.inject.Inject

class SaveLastCityUseCase @Inject constructor(
    private val repository: ISaveCityRepo
) : ISaveLastCityUseCase {

     override suspend fun execute(city: String)  {
           repository.saveCity(city)
     }
}
