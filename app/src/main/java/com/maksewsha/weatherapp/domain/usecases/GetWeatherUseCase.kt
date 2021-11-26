package com.maksewsha.weatherapp.domain.usecases

import com.maksewsha.weatherapp.domain.models.CityWeatherDomain
import com.maksewsha.weatherapp.domain.repository.CityRepository

class GetWeatherUseCase(private val cityRepository: CityRepository) {

    fun getWeatherById(id: Int): CityWeatherDomain{
        return cityRepository.getById(id)
    }
}