package com.maksewsha.weatherapp.data.models.weathermodels

data class SysInfo(
    val type: Int,
    val id: Int,
    val message: Float,
    val country: String,
    val sunrise: Long,
    val sunset: Long
)