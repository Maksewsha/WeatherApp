package com.maksewsha.weatherapp.domain.models

import kotlin.math.roundToInt

class CityWeatherInfoDomain(
    val weather: WeatherInfo,
    val base: String,
    val main: MainInfo,
    val visibility: Int,
    val wind: WindInfo,
    val clouds: CloudsInfo,
    val dt: Long,
    val sys: SysInfo,
    val timezone: Int,
    val id: Long,
    val name: String,
    val cod: Int
): CityWeather(){
    val tempCelsius = (main.tempD - 273.15f).roundToInt()

    class WeatherInfo(val idD: Int,
                      val mainD: String,
                      val descriptionD: String,
                      val iconD: String)
    class MainInfo(val tempD: Float,
                   val feelsLikeD: Float,
                   val tempMinD: Float,
                   val tempMaxD: Float,
                   val pressureD: Int,
                   val humidityD: Int)
    class WindInfo(
        val speedD: Float,
        val degD: Int
    )
    class CloudsInfo(val allD: Int)
    class SysInfo(val typeD: Int,
                  val idD: Int,
                  val messageD: Float,
                  val countryD: String,
                  val sunriseD: Long,
                  val sunsetD: Long)
}