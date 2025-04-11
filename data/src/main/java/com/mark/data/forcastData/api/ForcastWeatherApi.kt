package com.mark.data.forcastData.api


import com.mark.domain.currentDomain.response.CurrentWeatherResponse
import com.mark.domain.forcastDomain.response.ForcastWeatherResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ForcastWeatherApi {
   @FormUrlEncoded
   @POST(FORCAST_WEATHER_API)
   suspend fun getForcastWeather(@Field("key") key: String, @Field("q") city: String,@Field("days") days: Int): ForcastWeatherResponse
}