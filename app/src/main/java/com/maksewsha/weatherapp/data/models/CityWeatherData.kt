package com.maksewsha.weatherapp.data.models

import com.maksewsha.weatherapp.data.models.weathermodels.*
import com.maksewsha.weatherapp.domain.models.CityWeatherDomain

data class CityWeatherData(
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
    override val id: Long,
    override val name: String,
    val cod: Int
) : CityWeatherDomain()