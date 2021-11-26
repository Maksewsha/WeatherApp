package com.maksewsha.weatherapp.data.storages

import com.maksewsha.weatherapp.data.models.CityWeatherData

interface CityStorage {
    fun getById(id: Int): CityWeatherData?
    fun save(cityWeatherData: CityWeatherData): Boolean
}