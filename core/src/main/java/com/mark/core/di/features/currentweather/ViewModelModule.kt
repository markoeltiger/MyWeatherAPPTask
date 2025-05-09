package com.mark.core.di.features.currentweather


import com.mark.data.currentWeatherData.repo.CurrentWeatherRepo
import com.mark.domain.currentDomain.repo.ICurrentWeatherRepo
import com.mark.domain.currentDomain.usecase.GetCurrentWeatherUseCase
import com.mark.domain.currentDomain.usecase.IGetCurrentWeatherUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindCurrentWeatherRepo(repo: CurrentWeatherRepo): ICurrentWeatherRepo

    @Binds
    abstract fun bindGetCurrentWeatherUseCase(usecase: GetCurrentWeatherUseCase): IGetCurrentWeatherUseCase

}