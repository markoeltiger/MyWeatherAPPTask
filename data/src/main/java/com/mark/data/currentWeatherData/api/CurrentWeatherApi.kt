package com.mark.data.currentWeatherData.api


import com.mark.domain.currentDomain.response.CurrentWeatherResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface CurrentWeatherApi {
   @FormUrlEncoded
   @POST(CURRENT_WEATHER_API)
   suspend fun getCurrentWeather(@Field("key") key: String, @Field("q") city: String): CurrentWeatherResponse
}