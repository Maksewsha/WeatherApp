package com.maksewsha.weatherapp.data

import com.maksewsha.weatherapp.data.models.CityWeatherData
import com.maksewsha.weatherapp.domain.models.CityWeatherDomain
import com.maksewsha.weatherapp.domain.util.EntityMapper

class CityWeatherMapper : EntityMapper<CityWeatherData, CityWeatherDomain> {
    override fun mapFromEntity(entity: CityWeatherData): CityWeatherDomain = CityWeatherDomain(
        id = entity.id,
        name = entity.name,
        country = entity.sys.country,
        temp = entity.main.temp,
        weatherDescription = entity.weather[0].description
    )
}