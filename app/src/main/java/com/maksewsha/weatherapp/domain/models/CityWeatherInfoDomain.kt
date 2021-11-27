package com.maksewsha.weatherapp.domain.models

class CityWeatherInfoDomain(
    val id: Long,
    val name: String,
    val country: String,
    val weatherDescription: String,
    val temp: Float
): CityWeather()