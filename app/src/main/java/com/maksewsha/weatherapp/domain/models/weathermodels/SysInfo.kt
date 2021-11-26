package com.maksewsha.weatherapp.domain.models.weathermodels

data class SysInfo(
    val type: Int,
    val id: Int,
    val message: Float,
    val country: String,
    val sunrise: Long,
    val sunset: Long
)