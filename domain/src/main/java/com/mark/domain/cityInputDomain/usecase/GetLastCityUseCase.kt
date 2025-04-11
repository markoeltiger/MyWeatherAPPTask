package com.mark.domain.cityInputDomain.usecase


import com.mark.domain.cityInputDomain.repo.ISaveCityRepo
import com.mark.domain.currentUseCaseDomain.CurrentWeatherResult
import com.mark.domain.currentUseCaseDomain.mapToCurrentWeatherResult
import com.mark.domain.currentUseCaseDomain.repo.ICurrentWeatherRepo
import com.mark.domain.currentUseCaseDomain.usecase.IGetCurrentWeatherUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetLastCityUseCase @Inject constructor(
    private val repository: ISaveCityRepo
) : IGetLastCityUseCase {


    override   fun execute( ): Flow<String?> = repository.getLastCity()
    }
