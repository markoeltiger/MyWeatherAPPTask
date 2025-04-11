package com.mark.domain.cityInputDomain.usecase


import com.mark.domain.cityInputDomain.repo.ISaveCityRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLastCityUseCase @Inject constructor(
    private val repository: ISaveCityRepo
) : IGetLastCityUseCase {


    override   fun execute( ): Flow<String?> = repository.getLastCity()
    }
