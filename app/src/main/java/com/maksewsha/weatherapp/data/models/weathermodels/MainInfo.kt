package com.maksewsha.weatherapp.data.models.weathermodels

data class MainInfo(
    val temp: Float,
    val feelsLike: Float,
    val tempMin: Float,
    val tempMax: Float,
    val pressure: Int,
    val humidity: Int
)