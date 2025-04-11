package com.mark.core.di.features.forecastweather


import com.mark.data.currentWeatherData.repo.CurrentWeatherRepo
import com.mark.data.forcastData.repo.ForcastWeatherRepo
import com.mark.domain.currentDomain.repo.ICurrentWeatherRepo
import com.mark.domain.currentDomain.usecase.GetCurrentWeatherUseCase
import com.mark.domain.currentDomain.usecase.IGetCurrentWeatherUseCase
import com.mark.domain.forcastDomain.repo.IForcastWeatherRepo
import com.mark.domain.forcastDomain.usecase.GetForcastWeatherUseCase
import com.mark.domain.forcastDomain.usecase.IGetForcastWeatherUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindForecastWeatherRepo(repo: ForcastWeatherRepo): IForcastWeatherRepo

    @Binds
    abstract fun bindGetForecastWeatherUseCase(usecase: GetForcastWeatherUseCase): IGetForcastWeatherUseCase

}