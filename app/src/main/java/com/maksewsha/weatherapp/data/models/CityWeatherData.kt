package com.maksewsha.weatherapp.data.models

import com.google.gson.annotations.SerializedName
import com.maksewsha.weatherapp.data.models.weathermodels.*
import com.maksewsha.weatherapp.domain.models.CityWeather
import com.maksewsha.weatherapp.domain.models.CityWeatherDomain

data class CityWeatherData(
    @SerializedName("coords")
    val coords: CoordsInfo,
    @SerializedName("weather")
    val weather: Array<WeatherInfo>,
    @SerializedName("base")
    val base: String,
    @SerializedName("main")
    val main: MainInfo,
    @SerializedName("visibility")
    val visibility: Int,
    @SerializedName("wind")
    val wind: WindInfo,
    @SerializedName("clouds")
    val clouds: CloudsInfo,
    @SerializedName("dt")
    val dt: Long,
    @SerializedName("sys")
    val sys: SysInfo,
    @SerializedName("timezone")
    val timezone: Int,
    @SerializedName("id")
    val id: Long,
    @SerializedName("name")
    val name: String,
    @SerializedName("cod")
    val cod: Int
): CityWeather()