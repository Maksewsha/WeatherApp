package com.maksewsha.weatherapp.domain.models.weathermodels

data class WeatherInfo(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)