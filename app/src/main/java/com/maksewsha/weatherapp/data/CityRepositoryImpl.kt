package com.maksewsha.weatherapp.data

import com.maksewsha.weatherapp.data.models.CityWeatherData
import com.maksewsha.weatherapp.data.models.CityWeatherNetworkData
import com.maksewsha.weatherapp.data.storages.CityStorage
import com.maksewsha.weatherapp.data.storages.NetworkCityStorage
import com.maksewsha.weatherapp.domain.models.CityWeather
import com.maksewsha.weatherapp.domain.models.CityWeatherDomain
import com.maksewsha.weatherapp.domain.repository.CityRepository

class CityRepositoryImpl(private val networkStorage: NetworkCityStorage, private val localStorage: CityStorage) : CityRepository {

    private val mapper = CityWeatherMapper()

    override fun getByName(name: String): CityWeatherDomain {
        val dataFromSharedPref = localStorage.getByName(name)

        if (dataFromSharedPref is CityWeatherData.Fail){
            val dataFromNetwork = networkStorage.getByName(name)
            return if (dataFromNetwork !is CityWeatherData.Fail){
                save((dataFromNetwork as CityWeatherData.Success).cityWeatherNetworkData)
                mapper.mapFromEntity(dataFromNetwork)
            } else {
                mapper.mapFromEntity(dataFromNetwork)
            }
        }


        return mapper.mapFromEntity(dataFromSharedPref)
    }

    override fun save(cityWeather: CityWeather): Boolean {
        return localStorage.save(cityWeather as CityWeatherNetworkData)
    }
}

//TODO("Implement the check on possibility of network connection")