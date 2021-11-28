package com.maksewsha.weatherapp.domain.models

import kotlin.math.roundToInt

class CityWeatherInfoDomain(
    val id: Long,
    val name: String,
    val country: String,
    val weatherDescription: String,
    val tempKelvin: Int
): CityWeather(){
    val tempCelsius = (tempKelvin - 273.15f).roundToInt()
}