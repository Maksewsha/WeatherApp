package com.maksewsha.weatherapp.data.network

import android.os.AsyncTask
import android.util.Log
import com.google.gson.Gson
import com.maksewsha.weatherapp.BuildConfig
import com.maksewsha.weatherapp.data.models.CityWeatherData
import com.maksewsha.weatherapp.data.models.CityWeatherNetworkData
import java.io.FileNotFoundException
import java.lang.Exception
import java.net.URL

class NetworkLoader : AsyncTask<String, Unit, CityWeatherData>() {

    companion object {
        private const val OWM_KEY = BuildConfig.OWM_KEY
        private val gson = Gson()
    }

    override fun doInBackground(vararg name: String?): CityWeatherData {
        try {
            val text =
                URL("https://api.openweathermap.org/data/2.5/weather?q=${name[0]}&appid=$OWM_KEY").readText()
            return CityWeatherData.Success(gson.fromJson(text, CityWeatherNetworkData::class.java))
        } catch (e: FileNotFoundException){
            return CityWeatherData.Fail(Exception("404"))
        }

    }
}

//TODO("Implement the check on 404 error")