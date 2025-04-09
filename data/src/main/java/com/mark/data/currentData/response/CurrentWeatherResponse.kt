package com.mark.data.currentData.response

import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(
    @SerializedName("location" ) var location : Location? = Location(),
    @SerializedName("current"  ) var current  : Current?  = Current()
)
data class Location (

    @SerializedName("name"            ) var name           : String? = null,
    @SerializedName("region"          ) var region         : String? = null,
    @SerializedName("country"         ) var country        : String? = null,
    @SerializedName("lat"             ) var lat            : Double? = null,
    @SerializedName("lon"             ) var lon            : Double? = null,
    @SerializedName("tz_id"           ) var tzId           : String? = null,
    @SerializedName("localtime_epoch" ) var localtimeEpoch : Int?    = null,
    @SerializedName("localtime"       ) var localtime      : String? = null
)
data class Condition (

    @SerializedName("text" ) var text : String? = null,
    @SerializedName("icon" ) var icon : String? = null,
    @SerializedName("code" ) var code : Int?    = null

)
data class Current (

    @SerializedName("last_updated_epoch" ) var lastUpdatedEpoch : Int?       = null,
    @SerializedName("last_updated"       ) var lastUpdated      : String?    = null,
    @SerializedName("temp_c"             ) var tempC            : Double?    = null,
    @SerializedName("temp_f"             ) var tempF            : Int?       = null,
    @SerializedName("is_day"             ) var isDay            : Int?       = null,
    @SerializedName("condition"          ) var condition        : Condition? = Condition(),
    @SerializedName("wind_mph"           ) var windMph          : Double?    = null,
    @SerializedName("wind_kph"           ) var windKph          : Double?    = null,
    @SerializedName("wind_degree"        ) var windDegree       : Int?       = null,
    @SerializedName("wind_dir"           ) var windDir          : String?    = null,
    @SerializedName("pressure_mb"        ) var pressureMb       : Int?       = null,
    @SerializedName("pressure_in"        ) var pressureIn       : Double?    = null,
    @SerializedName("precip_mm"          ) var precipMm         : Int?       = null,
    @SerializedName("precip_in"          ) var precipIn         : Int?       = null,
    @SerializedName("humidity"           ) var humidity         : Int?       = null,
    @SerializedName("cloud"              ) var cloud            : Int?       = null,
    @SerializedName("feelslike_c"        ) var feelslikeC       : Double?    = null,
    @SerializedName("feelslike_f"        ) var feelslikeF       : Double?    = null,
    @SerializedName("windchill_c"        ) var windchillC       : Double?    = null,
    @SerializedName("windchill_f"        ) var windchillF       : Double?    = null,
    @SerializedName("heatindex_c"        ) var heatindexC       : Int?       = null,
    @SerializedName("heatindex_f"        ) var heatindexF       : Double?    = null,
    @SerializedName("dewpoint_c"         ) var dewpointC        : Double?    = null,
    @SerializedName("dewpoint_f"         ) var dewpointF        : Double?    = null,
    @SerializedName("vis_km"             ) var visKm            : Int?       = null,
    @SerializedName("vis_miles"          ) var visMiles         : Int?       = null,
    @SerializedName("uv"                 ) var uv               : Int?       = null,
    @SerializedName("gust_mph"           ) var gustMph          : Double?    = null,
    @SerializedName("gust_kph"           ) var gustKph          : Double?    = null

)