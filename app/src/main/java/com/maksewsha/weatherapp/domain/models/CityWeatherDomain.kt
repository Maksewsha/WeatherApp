package com.maksewsha.weatherapp.domain.models

open class CityWeatherDomain(
    open val id: Long? = null,
    open val name: String? = null,
    open val country: String? = null,
    open val temp: Float? = null,
    open val weatherDescription: String? = null
)