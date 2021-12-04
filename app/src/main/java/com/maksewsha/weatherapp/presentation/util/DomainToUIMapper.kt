package com.maksewsha.weatherapp.presentation.util

import com.maksewsha.weatherapp.domain.models.CityWeatherDomain
import com.maksewsha.weatherapp.domain.util.EntityMapper
import com.maksewsha.weatherapp.presentation.models.CityWeatherInfoUI
import com.maksewsha.weatherapp.presentation.models.CityWeatherUI

class DomainToUIMapper:  EntityMapper<CityWeatherDomain, CityWeatherUI> {

    companion object{
        private val ICON_URL = "http://openweathermap.org/img/wn/"
    }

    override fun mapFromEntity(entity: CityWeatherDomain): CityWeatherUI {
        return when(entity){
            is CityWeatherDomain.Success -> CityWeatherUI.Success(CityWeatherInfoUI(
                name = entity.cityWeatherInfoDomain.name,
                tempCelsius = entity.cityWeatherInfoDomain.tempCelsius,
                description = entity.cityWeatherInfoDomain.weather.descriptionD,
                country = entity.cityWeatherInfoDomain.sys.countryD,
                icon = ICON_URL + entity.cityWeatherInfoDomain.weather.iconD + ".png"
            ))
            is CityWeatherDomain.Fail -> CityWeatherUI.Fail(message = entity.message)
        }
    }

}