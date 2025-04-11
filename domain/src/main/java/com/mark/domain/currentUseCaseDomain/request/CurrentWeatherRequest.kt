package com.mark.domain.currentUseCaseDomain.request

import com.google.gson.annotations.SerializedName

data class CurrentWeatherRequest(
    @SerializedName("city")
    val city: String,
    @SerializedName("dial")
    val dial: String
)