package com.maksewsha.weatherapp.domain.repository

import com.maksewsha.weatherapp.domain.models.CityWeather
import com.maksewsha.weatherapp.domain.models.CityWeatherDomain

interface CityRepository {

    fun getByName(name: String) : CityWeatherDomain

    fun save(cityWeather: CityWeather) : Boolean
}