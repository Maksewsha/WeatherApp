package com.maksewsha.weatherapp.data.storages

import com.maksewsha.weatherapp.data.models.CityWeatherData

class NetworkCityStorage : CityStorage {
    override fun fetchById(id: Int): CityWeatherData {
        TODO("Not yet implemented")
    }

    override fun save(cityWeatherData: CityWeatherData): Boolean {
        TODO("Not yet implemented")
    }
}