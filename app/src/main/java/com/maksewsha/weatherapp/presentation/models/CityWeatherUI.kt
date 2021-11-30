package com.maksewsha.weatherapp.presentation.models

import com.maksewsha.weatherapp.domain.models.CityWeather

sealed class CityWeatherUI{
    class Success(val cityWeatherInfoUI: CityWeatherInfoUI): CityWeatherUI()
    class Fail(val message: Int): CityWeatherUI()
}