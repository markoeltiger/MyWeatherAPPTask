package com.mark.core.di.features.forecastweather

import com.mark.data.currentWeatherData.api.CurrentWeatherApi
import com.mark.data.forcastData.api.ForcastWeatherApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@InstallIn(ViewModelComponent::class)
@Module
class ForecastWeatherRestModule {

    @Provides
    fun provideForeCastAPI(retrofit: Retrofit): ForcastWeatherApi {
        return retrofit.create(ForcastWeatherApi::class.java)
    }
}