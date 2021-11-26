package com.maksewsha.weatherapp.data.storages

import com.maksewsha.weatherapp.data.models.CityWeatherData

interface CityStorage {
    fun getByName(name: String): CityWeatherData?
    fun save(cityWeatherData: CityWeatherData): Boolean
}