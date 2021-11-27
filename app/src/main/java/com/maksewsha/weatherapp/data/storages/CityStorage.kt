package com.maksewsha.weatherapp.data.storages

import com.maksewsha.weatherapp.data.models.CityWeatherData
import com.maksewsha.weatherapp.data.models.CityWeatherNetworkData

interface CityStorage {
    fun getByName(name: String): CityWeatherData
    fun save(cityWeatherNetworkData: CityWeatherNetworkData): Boolean
}