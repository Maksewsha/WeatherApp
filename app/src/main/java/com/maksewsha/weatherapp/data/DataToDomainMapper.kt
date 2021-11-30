package com.maksewsha.weatherapp.data

import com.maksewsha.weatherapp.R
import com.maksewsha.weatherapp.data.models.CityWeatherData
import com.maksewsha.weatherapp.domain.models.CityWeather
import com.maksewsha.weatherapp.domain.models.CityWeatherDomain
import com.maksewsha.weatherapp.domain.models.CityWeatherInfoDomain
import com.maksewsha.weatherapp.domain.models.ErrorType
import com.maksewsha.weatherapp.domain.util.EntityMapper

class DataToDomainMapper : EntityMapper<CityWeatherData, CityWeatherDomain> {
    override fun mapFromEntity(entity: CityWeatherData): CityWeatherDomain {
        return when(entity){
            is CityWeatherData.Success -> {
                CityWeatherDomain.Success(
                    CityWeatherInfoDomain(
                        weather = CityWeatherInfoDomain.WeatherInfo(
                            idD = entity.cityWeatherNetworkData.weather[0].idN,
                            mainD = entity.cityWeatherNetworkData.weather[0].mainN,
                            descriptionD = entity.cityWeatherNetworkData.weather[0].descriptionN,
                            iconD = entity.cityWeatherNetworkData.weather[0].iconN
                        ),
                        base = entity.cityWeatherNetworkData.base,
                        main = CityWeatherInfoDomain.MainInfo(
                            tempD = entity.cityWeatherNetworkData.main.tempN,
                            feelsLikeD = entity.cityWeatherNetworkData.main.feelsLikeN,
                            tempMinD = entity.cityWeatherNetworkData.main.tempMinN,
                            tempMaxD = entity.cityWeatherNetworkData.main.tempMaxN,
                            pressureD = entity.cityWeatherNetworkData.main.pressureN,
                            humidityD = entity.cityWeatherNetworkData.main.humidityN
                        ),
                        visibility = entity.cityWeatherNetworkData.visibility,
                        wind = CityWeatherInfoDomain.WindInfo(
                            speedD = entity.cityWeatherNetworkData.wind.speedN,
                            degD = entity.cityWeatherNetworkData.wind.degN
                        ),
                        clouds = CityWeatherInfoDomain.CloudsInfo(
                            allD = entity.cityWeatherNetworkData.clouds.allN
                        ),
                        dt = entity.cityWeatherNetworkData.dt,
                        sys = CityWeatherInfoDomain.SysInfo(
                            typeD = entity.cityWeatherNetworkData.sys.typeN,
                            idD = entity.cityWeatherNetworkData.sys.idN,
                            messageD = entity.cityWeatherNetworkData.sys.messageN,
                            countryD = entity.cityWeatherNetworkData.sys.countryN,
                            sunriseD = entity.cityWeatherNetworkData.sys.sunriseN,
                            sunsetD = entity.cityWeatherNetworkData.sys.sunsetN
                        ),
                        timezone = entity.cityWeatherNetworkData.timezone,
                        id = entity.cityWeatherNetworkData.id,
                        name = entity.cityWeatherNetworkData.name,
                        cod = entity.cityWeatherNetworkData.cod
                    )
                )
            }
            is CityWeatherData.Fail -> {
                CityWeatherDomain.Fail(
                    errorType = entity.errorType,
                    message = when(entity.errorType){
                        ErrorType.NoFoundError -> R.string.noFoundError
                        ErrorType.ConnectivityError -> R.string.connectivityError
                        ErrorType.OtherError -> R.string.otherError
                    }
                )
            }
        }
    }
}