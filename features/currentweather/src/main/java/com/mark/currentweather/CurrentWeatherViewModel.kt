package com.mark.currentweather

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mark.domain.currentUseCaseDomain.CurrentWeatherResult
import com.mark.domain.currentUseCaseDomain.usecase.IGetCurrentWeatherUseCase

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CurrentWeatherViewModel @Inject constructor(
    private val getCurrentWeatherUseCase: IGetCurrentWeatherUseCase,
) : ViewModel() {
    private var currentWeather: CurrentWeatherState? = null
    private val _weatherState = MutableStateFlow<CurrentWeatherState?>(null)
    val weatherState: StateFlow<CurrentWeatherState?> = _weatherState

    // StateFlow to manage loading state
    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        fetchWeatherData("London")
    }


    private fun fetchWeatherData(city: String) {
        viewModelScope.launch {
            _isLoading.value = true
            getCurrentWeatherUseCase.execute(city).collect { result ->
                when (result) {
                    is CurrentWeatherResult.SuccessResult -> {


                        currentWeather = CurrentWeatherState(
                            temperature = result.currentWeather.temperature.toString(),
                            city = result.currentWeather.city,
                            precipitation = result.currentWeather.humidity.toString(),
                            maxTemp = result.currentWeather.maxTemperature.toString(),
                            minTemp = result.currentWeather.minTemperature.toString(),
                        )
                        _weatherState.value = currentWeather
                    }

                    else -> {
                        Log.d("TAG", "fetchWeatherData: Error")
                    }
                }

            }



            _isLoading.value = false
        }
    }
}

