package com.maksewsha.weatherapp.domain.repository

import com.maksewsha.weatherapp.domain.models.CityWeatherDomain

interface CityRepository {

    fun getById() : CityWeatherDomain

    fun save(cityWeatherDomain: CityWeatherDomain) : Boolean
}