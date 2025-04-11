package com.mark.domain.forcastDomain.response
import java.util.Date
import java.util.List
import com.google.gson.annotations.SerializedName

data class ForcastWeatherResponse(
    @SerializedName("location") var location : Location,
    @SerializedName("current") var current : Current,
    @SerializedName("forecast") var forecast : Forecast
)
data class Location (

    @SerializedName("name") var name : String,
    @SerializedName("region") var region : String,
    @SerializedName("country") var country : String,
    @SerializedName("lat") var lat : Double,
    @SerializedName("lon") var lon : Double,
    @SerializedName("tz_id") var tzId : String,
    @SerializedName("localtime_epoch") var localtimeEpoch : Int,
    @SerializedName("localtime") var localtime : String

)
data class Condition (

    @SerializedName("text") var text : String,
    @SerializedName("icon") var icon : String,
    @SerializedName("code") var code : Int

)
data class Current (

    @SerializedName("last_updated_epoch") var lastUpdatedEpoch : Int,
    @SerializedName("last_updated") var lastUpdated : String,
    @SerializedName("temp_c") var tempC : Double,
    @SerializedName("temp_f") var tempF : Double,
    @SerializedName("is_day") var isDay : Int,
    @SerializedName("condition") var condition : Condition,
    @SerializedName("wind_mph") var windMph : Double,
    @SerializedName("wind_kph") var windKph : Double,
    @SerializedName("wind_degree") var windDegree : Int,
    @SerializedName("wind_dir") var windDir : String,
    @SerializedName("pressure_mb") var pressureMb : Int,
    @SerializedName("pressure_in") var pressureIn : Double,
    @SerializedName("precip_mm") var precipMm : Int,
    @SerializedName("precip_in") var precipIn : Int,
    @SerializedName("humidity") var humidity : Int,
    @SerializedName("cloud") var cloud : Int,
    @SerializedName("feelslike_c") var feelslikeC : Double,
    @SerializedName("feelslike_f") var feelslikeF : Int,
    @SerializedName("windchill_c") var windchillC : Double,
    @SerializedName("windchill_f") var windchillF : Double,
    @SerializedName("heatindex_c") var heatindexC : Double,
    @SerializedName("heatindex_f") var heatindexF : Double,
    @SerializedName("dewpoint_c") var dewpointC : Double,
    @SerializedName("dewpoint_f") var dewpointF : Double,
    @SerializedName("vis_km") var visKm : Int,
    @SerializedName("vis_miles") var visMiles : Int,
    @SerializedName("uv") var uv : Double,
    @SerializedName("gust_mph") var gustMph : Double,
    @SerializedName("gust_kph") var gustKph : Double

)

data class Day (

    @SerializedName("maxtemp_c") var maxtempC : Double,
    @SerializedName("maxtemp_f") var maxtempF : Double,
    @SerializedName("mintemp_c") var mintempC : Double,
    @SerializedName("mintemp_f") var mintempF : Double,
    @SerializedName("avgtemp_c") var avgtempC : Double,
    @SerializedName("avgtemp_f") var avgtempF : Double,
    @SerializedName("maxwind_mph") var maxwindMph : Int,
    @SerializedName("maxwind_kph") var maxwindKph : Double,
    @SerializedName("totalprecip_mm") var totalprecipMm : Int,
    @SerializedName("totalprecip_in") var totalprecipIn : Int,
    @SerializedName("totalsnow_cm") var totalsnowCm : Int,
    @SerializedName("avgvis_km") var avgvisKm : Int,
    @SerializedName("avgvis_miles") var avgvisMiles : Int,
    @SerializedName("avghumidity") var avghumidity : Int,
    @SerializedName("daily_will_it_rain") var dailyWillItRain : Int,
    @SerializedName("daily_chance_of_rain") var dailyChanceOfRain : Int,
    @SerializedName("daily_will_it_snow") var dailyWillItSnow : Int,
    @SerializedName("daily_chance_of_snow") var dailyChanceOfSnow : Int,
    @SerializedName("condition") var condition : Condition,
    @SerializedName("uv") var uv : Double

)
data class Astro (

    @SerializedName("sunrise") var sunrise : String,
    @SerializedName("sunset") var sunset : String,
    @SerializedName("moonrise") var moonrise : String,
    @SerializedName("moonset") var moonset : String,
    @SerializedName("moon_phase") var moonPhase : String,
    @SerializedName("moon_illumination") var moonIllumination : Int,
    @SerializedName("is_moon_up") var isMoonUp : Int,
    @SerializedName("is_sun_up") var isSunUp : Int

)


data class Hour (

    @SerializedName("time_epoch") var timeEpoch : Int,
    @SerializedName("time") var time : String,
    @SerializedName("temp_c") var tempC : Double,
    @SerializedName("temp_f") var tempF : Int,
    @SerializedName("is_day") var isDay : Int,
    @SerializedName("condition") var condition : Condition,
    @SerializedName("wind_mph") var windMph : Double,
    @SerializedName("wind_kph") var windKph : Double,
    @SerializedName("wind_degree") var windDegree : Int,
    @SerializedName("wind_dir") var windDir : String,
    @SerializedName("pressure_mb") var pressureMb : Int,
    @SerializedName("pressure_in") var pressureIn : Double,
    @SerializedName("precip_mm") var precipMm : Int,
    @SerializedName("precip_in") var precipIn : Int,
    @SerializedName("snow_cm") var snowCm : Int,
    @SerializedName("humidity") var humidity : Int,
    @SerializedName("cloud") var cloud : Int,
    @SerializedName("feelslike_c") var feelslikeC : Double,
    @SerializedName("feelslike_f") var feelslikeF : Double,
    @SerializedName("windchill_c") var windchillC : Double,
    @SerializedName("windchill_f") var windchillF : Double,
    @SerializedName("heatindex_c") var heatindexC : Double,
    @SerializedName("heatindex_f") var heatindexF : Int,
    @SerializedName("dewpoint_c") var dewpointC : Double,
    @SerializedName("dewpoint_f") var dewpointF : Int,
    @SerializedName("will_it_rain") var willItRain : Int,
    @SerializedName("chance_of_rain") var chanceOfRain : Int,
    @SerializedName("will_it_snow") var willItSnow : Int,
    @SerializedName("chance_of_snow") var chanceOfSnow : Int,
    @SerializedName("vis_km") var visKm : Int,
    @SerializedName("vis_miles") var visMiles : Int,
    @SerializedName("gust_mph") var gustMph : Double,
    @SerializedName("gust_kph") var gustKph : Int,
    @SerializedName("uv") var uv : Int

)
data class Forecastday (

    @SerializedName("date") var date : Date,
    @SerializedName("date_epoch") var dateEpoch : Int,
    @SerializedName("day") var day : Day,
    @SerializedName("astro") var astro : Astro,
    @SerializedName("hour") var hour : List<Hour>

)
data class Forecast (

    @SerializedName("forecastday") var forecastday : List<Forecastday>

)