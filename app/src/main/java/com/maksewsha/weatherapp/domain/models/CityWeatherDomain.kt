package com.maksewsha.weatherapp.domain.models

sealed class CityWeatherDomain : CityWeather(){
    class Success(val cityWeatherInfoDomain: CityWeatherInfoDomain): CityWeatherDomain()
    class Fail(val errorType: ErrorType, val message: Int): CityWeatherDomain()
}