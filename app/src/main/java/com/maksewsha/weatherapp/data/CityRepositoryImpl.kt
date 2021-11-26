package com.maksewsha.weatherapp.data

import com.maksewsha.weatherapp.data.storages.CityStorage
import com.maksewsha.weatherapp.domain.models.CityWeatherDomain
import com.maksewsha.weatherapp.domain.repository.CityRepository

class CityRepositoryImpl(networkStorage: CityStorage, localStorage: CityStorage) : CityRepository {
    override fun getById(): CityWeatherDomain {
        TODO("Not yet implemented")
    }

    override fun save(cityWeatherDomain: CityWeatherDomain): Boolean {
        TODO("Not yet implemented")
    }
}