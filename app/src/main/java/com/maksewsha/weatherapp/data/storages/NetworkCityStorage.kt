package com.maksewsha.weatherapp.data.storages

import com.google.gson.Gson
import com.maksewsha.weatherapp.BuildConfig
import com.maksewsha.weatherapp.data.models.CityWeatherData
import com.maksewsha.weatherapp.data.network.NetworkLoader
import org.json.JSONObject
import java.net.URL
import java.util.concurrent.ExecutorService

class NetworkCityStorage{

    fun getByName(name: String): CityWeatherData {
        return NetworkLoader().execute(name).get()
    }
}