package com.maksewsha.weatherapp.data.models

import com.google.gson.annotations.SerializedName
import com.maksewsha.weatherapp.domain.models.CityWeather


data class CityWeatherNetworkData(
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
): CityWeather() {
    class CoordsInfo(
        @SerializedName("lat")
        val latN: Float,
        @SerializedName("lon")
        val lonN: Float
    )

    class WeatherInfo(
        @SerializedName("id")
        val idN: Int,
        @SerializedName("main")
        val mainN: String,
        @SerializedName("description")
        val descriptionN: String,
        @SerializedName("icon")
        val iconN: String
    )

    class MainInfo(
        @SerializedName("temp")
        val tempN: Float,
        @SerializedName("feels_like")
        val feelsLikeN: Float,
        @SerializedName("temp_min")
        val tempMinN: Float,
        @SerializedName("temp_max")
        val tempMaxN: Float,
        @SerializedName("pressure")
        val pressureN: Int,
        @SerializedName("humidity")
        val humidityN: Int
    )

    class WindInfo(
        @SerializedName("speed")
        val speedN: Float,
        @SerializedName("deg")
        val degN: Int
    )

    class CloudsInfo(
        @SerializedName("all")
        val allN: Int
    )

    class SysInfo(
        @SerializedName("type")
        val typeN: Int,
        @SerializedName("id")
        val idN: Int,
        @SerializedName("message")
        val messageN: Float,
        @SerializedName("country")
        val countryN: String,
        @SerializedName("sunrise")
        val sunriseN: Long,
        @SerializedName("sunset")
        val sunsetN: Long
    )
}
