package com.mark.core.currentweather

import com.mark.data.currentWeatherData.api.CurrentWeatherApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@InstallIn(ViewModelComponent::class)
@Module
class CurrentWeatherRestModule {

    @Provides
    fun provideCurrentWeatherAPI(retrofit: Retrofit): CurrentWeatherApi {
        return retrofit.create(CurrentWeatherApi::class.java)
    }
}