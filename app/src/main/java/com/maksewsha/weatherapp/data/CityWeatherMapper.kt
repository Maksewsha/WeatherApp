package com.maksewsha.weatherapp.data

import com.maksewsha.weatherapp.R
import com.maksewsha.weatherapp.data.models.CityWeatherData
import com.maksewsha.weatherapp.domain.models.CityWeatherDomain
import com.maksewsha.weatherapp.domain.models.CityWeatherInfoDomain
import com.maksewsha.weatherapp.domain.models.ErrorType
import com.maksewsha.weatherapp.domain.util.EntityMapper
import kotlin.math.roundToInt

class CityWeatherMapper : EntityMapper<CityWeatherData, CityWeatherDomain> {
    override fun mapFromEntity(entity: CityWeatherData): CityWeatherDomain {
        return when(entity){
            is CityWeatherData.Success -> {
                CityWeatherDomain.Success(
                    CityWeatherInfoDomain(
                        id = entity.cityWeatherNetworkData.id,
                        name = entity.cityWeatherNetworkData.name,
                        country = entity.cityWeatherNetworkData.sys.country,
                        tempKelvin = entity.cityWeatherNetworkData.main.temp.roundToInt(),
                        weatherDescription = entity.cityWeatherNetworkData.weather[0].description
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