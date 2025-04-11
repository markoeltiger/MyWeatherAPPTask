package com.mark.homefeature

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mark.domain.cityInputDomain.usecase.GetLastCityUseCase
import com.mark.domain.cityInputDomain.usecase.IGetLastCityUseCase
import com.mark.domain.cityInputDomain.usecase.ISaveLastCityUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val saveCityUseCase: ISaveLastCityUseCase,
    private val getLastCityUseCase: IGetLastCityUseCase
) : ViewModel() {

    var uiState by mutableStateOf(CityInputUiState())
        private set

    init {
        viewModelScope.launch {
            getLastCityUseCase.execute().collect {
                it?.let {
                    uiState = uiState.copy(cityName = it)
                }
            }
        }
    }

    fun onCityNameChange(newCity: String) {
        uiState = uiState.copy(cityName = newCity)
    }

    fun onSubmitCity() {
        if (uiState.cityName.isBlank()) {
            uiState = uiState.copy(isValid = false, errorMessage = "City name cannot be empty")
            return
        }

        viewModelScope.launch {
            saveCityUseCase.execute(uiState.cityName)
            uiState = uiState.copy(isValid = true, errorMessage = null)
        }
    }
}