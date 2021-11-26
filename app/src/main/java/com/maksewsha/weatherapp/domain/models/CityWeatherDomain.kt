package com.maksewsha.weatherapp.domain.models

import com.maksewsha.weatherapp.domain.models.weathermodels.*


data class CityWeatherDomain(
    val coords: CoordsInfo,
    val weather: List<WeatherInfo>,
    val base: String,
    val main: MainInfo,
    val visibility: Int,
    val wind: WindInfo,
    val clouds: CloudsInfo,
    val dt: Long,
    val sys: SysInfo,
    val timezone: Int,
    val id: Long,
    val name: String,
    val cod: Int
)