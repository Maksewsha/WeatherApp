package com.maksewsha.weatherapp.data

import com.maksewsha.weatherapp.data.models.CityWeatherData
import com.maksewsha.weatherapp.domain.models.CityWeatherDomain
import com.maksewsha.weatherapp.domain.models.CityWeatherInfoDomain
import com.maksewsha.weatherapp.domain.util.EntityMapper

class CityWeatherMapper : EntityMapper<CityWeatherData, CityWeatherDomain> {
    override fun mapFromEntity(entity: CityWeatherData): CityWeatherDomain {
        return when(entity){
            is CityWeatherData.Success -> {
                CityWeatherDomain.Success(
                    CityWeatherInfoDomain(
                        id = entity.cityWeatherNetworkData.id,
                        name = entity.cityWeatherNetworkData.name,
                        country = entity.cityWeatherNetworkData.sys.country,
                        temp = entity.cityWeatherNetworkData.main.temp,
                        weatherDescription = entity.cityWeatherNetworkData.weather[0].description
                    )
                )
            }
            is CityWeatherData.Fail -> {
                CityWeatherDomain.Fail(
                    exception = entity.exception
                )
            }
        }
    }
}