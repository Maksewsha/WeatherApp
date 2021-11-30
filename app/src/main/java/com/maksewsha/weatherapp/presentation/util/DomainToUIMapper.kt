package com.maksewsha.weatherapp.presentation.util

import com.maksewsha.weatherapp.domain.models.CityWeatherDomain
import com.maksewsha.weatherapp.domain.util.EntityMapper
import com.maksewsha.weatherapp.presentation.models.CityWeatherInfoUI
import com.maksewsha.weatherapp.presentation.models.CityWeatherUI

class DomainToUIMapper:  EntityMapper<CityWeatherDomain, CityWeatherUI> {
    override fun mapFromEntity(entity: CityWeatherDomain): CityWeatherUI {
        return when(entity){
            is CityWeatherDomain.Success -> CityWeatherUI.Success(CityWeatherInfoUI(
                name = entity.cityWeatherInfoDomain.name,
                tempCelsius = entity.cityWeatherInfoDomain.tempCelsius,
                description = entity.cityWeatherInfoDomain.weather.descriptionD,
                country = entity.cityWeatherInfoDomain.sys.countryD
            ))
            is CityWeatherDomain.Fail -> CityWeatherUI.Fail(message = entity.message)
        }
    }

}