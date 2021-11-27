package com.maksewsha.weatherapp.data.models

import com.maksewsha.weatherapp.domain.models.CityWeather

sealed class CityWeatherData : CityWeather(){
    class Success(val cityWeatherNetworkData: CityWeatherNetworkData): CityWeatherData()
    class Fail(val exception: Exception): CityWeatherData()
}