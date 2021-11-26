package com.maksewsha.weatherapp.data

import com.maksewsha.weatherapp.data.models.CityWeatherData
import com.maksewsha.weatherapp.data.storages.CityStorage
import com.maksewsha.weatherapp.data.storages.NetworkCityStorage
import com.maksewsha.weatherapp.domain.models.CityWeatherDomain
import com.maksewsha.weatherapp.domain.repository.CityRepository

class CityRepositoryImpl(private val networkStorage: NetworkCityStorage, private val localStorage: CityStorage) : CityRepository {

    private val mapper = CityWeatherMapper()

    override fun getById(id: Int): CityWeatherDomain {
        val dataFromSharedPref = localStorage.getById(id)

        return mapper.mapFromEntity(dataFromSharedPref ?: networkStorage.getById(id))
    }

    override fun save(cityWeatherDomain: CityWeatherDomain): Boolean {
        return localStorage.save(cityWeatherDomain as CityWeatherData)
    }
}