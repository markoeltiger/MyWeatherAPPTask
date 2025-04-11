package com.mark.homefeature

data class CityInputUiState(
    val cityName: String = "",
    val isValid: Boolean = true,
    val errorMessage: String? = null
)