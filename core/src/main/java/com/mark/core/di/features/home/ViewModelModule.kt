package com.mark.core.di.features.home


import com.mark.data.homeDomain.repo.CityRepositoryImpl
import com.mark.domain.cityInputDomain.repo.ISaveCityRepo
import com.mark.domain.cityInputDomain.usecase.GetLastCityUseCase
import com.mark.domain.cityInputDomain.usecase.IGetLastCityUseCase
import com.mark.domain.cityInputDomain.usecase.ISaveLastCityUseCase
import com.mark.domain.cityInputDomain.usecase.SaveLastCityUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindHomeCityRepo(repo: CityRepositoryImpl): ISaveCityRepo

    @Binds
    abstract fun bindGetLastCityUseCase(usecase: GetLastCityUseCase): IGetLastCityUseCase
    @Binds
    abstract fun bindSaveLastCityUseCase(usecase: SaveLastCityUseCase): ISaveLastCityUseCase

}