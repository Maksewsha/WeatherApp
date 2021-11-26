package com.maksewsha.weatherapp.data.models

import com.maksewsha.weatherapp.data.models.weathermodels.*
import com.maksewsha.weatherapp.domain.models.weathermodels.CoordsInfo
import com.maksewsha.weatherapp.domain.models.weathermodels.MainInfo
import com.maksewsha.weatherapp.domain.models.weathermodels.SysInfo
import com.maksewsha.weatherapp.domain.models.weathermodels.WeatherInfo
import com.maksewsha.weatherapp.domain.models.weathermodels.WindInfo

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
    val id: Long,
    val name: String,
    val cod: Int
)