package com.mark.forcastfeature

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mark.domain.currentDomain.CurrentWeatherResult
import com.mark.domain.currentDomain.usecase.IGetCurrentWeatherUseCase
import com.mark.domain.forcastDomain.ForcasttWeatherResult
import com.mark.domain.forcastDomain.repo.IForcastWeatherRepo
import com.mark.domain.forcastDomain.usecase.IGetForcastWeatherUseCase

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ForecastViewModel @Inject constructor(
    private val getForecastWeatherUseCase: IGetForcastWeatherUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow(ForecastWeatherState())
    val state: StateFlow<ForecastWeatherState> = _state.asStateFlow()
    fun processIntent(intent: ForecastIntent) {
        when (intent) {
            is ForecastIntent.LoadForecast -> loadForecast(intent.city)
            is ForecastIntent.RefreshForecast -> refreshForecast()
        }
    }
    private fun loadForecast(city: String) {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true, city = city)

            getForecastWeatherUseCase.execute(city).collect { result ->
                when (result) {
                    is ForcasttWeatherResult.SuccessResult -> {


                        _state.value = _state.value.copy(days = result.forecastWeather.forcast.forecastday)

                    }

                    else -> {
                        Log.d("TAG", "fetchWeatherData: Error")
                    }
                }

            }
            _state.value = _state.value.copy(isLoading = false)

        }
    }
    private fun refreshForecast() {
        loadForecast(_state.value.city)
    }
}

