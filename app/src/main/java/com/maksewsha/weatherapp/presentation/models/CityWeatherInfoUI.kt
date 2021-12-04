package com.maksewsha.weatherapp.presentation.models

import com.maksewsha.weatherapp.domain.models.CityWeather

class CityWeatherInfoUI(
    val name: String,
    val tempCelsius: Int,
    val description: String,
    val country: String,
    val icon: String
) : CityWeather()