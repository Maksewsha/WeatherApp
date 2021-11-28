package com.maksewsha.weatherapp.data.models

import com.maksewsha.weatherapp.domain.models.CityWeather
import com.maksewsha.weatherapp.domain.models.ErrorType

sealed class CityWeatherData : CityWeather(){
    class Success(val cityWeatherNetworkData: CityWeatherNetworkData): CityWeatherData()
    class Fail(val errorType: ErrorType): CityWeatherData()
}