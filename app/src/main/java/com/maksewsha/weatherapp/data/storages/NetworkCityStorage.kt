package com.maksewsha.weatherapp.data.storages

import com.google.gson.Gson
import com.maksewsha.weatherapp.BuildConfig
import com.maksewsha.weatherapp.data.models.CityWeatherData
import org.json.JSONObject
import java.net.URL

class NetworkCityStorage{

    companion object{
        private const val OWM_KEY = BuildConfig.OWM_KEY
        private val gson = Gson()
    }

    fun getById(id: Int): CityWeatherData {
        val text = URL("https://api.openweathermap.org/data/2.5/weather?id=$id&appid=$OWM_KEY").readBytes()
        return gson.fromJson(text.toString(), CityWeatherData::class.java)
    }
}