package com.maksewsha.weatherapp.domain.models

sealed class CityWeatherDomain : CityWeather(){
    class Success(val cityWeatherInfoDomain: CityWeatherInfoDomain): CityWeatherDomain()
    class Fail(val exception: Exception): CityWeatherDomain()
}