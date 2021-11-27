package com.maksewsha.weatherapp.data.storages

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.maksewsha.weatherapp.data.models.CityWeatherData
import com.maksewsha.weatherapp.data.models.CityWeatherNetworkData
import com.maksewsha.weatherapp.domain.models.CityWeatherInfoDomain

class SharedPrefCityStorage(context: Context) : CityStorage {

    companion object{
        private const val KEY_PREFS_CITY_LIST = "cityListPrefs"
        private val gson = Gson()
    }

    private val sharedPrefs = context.getSharedPreferences(KEY_PREFS_CITY_LIST, Context.MODE_PRIVATE)

    override fun getByName(name: String): CityWeatherData{
        return if (sharedPrefs.contains("$name")){
            val data = sharedPrefs.getString("$name", "")
            CityWeatherData.Success(gson.fromJson(data!!.reader(), CityWeatherNetworkData::class.java))
        } else {
            CityWeatherData.Fail(Exception("404"))
        }
    }

    override fun save(cityWeatherNetworkData: CityWeatherNetworkData): Boolean {
        return if (!sharedPrefs.contains("${cityWeatherNetworkData.id}")){
            val edit = sharedPrefs.edit()
            edit.putString("${cityWeatherNetworkData.id}", gson.toJson(cityWeatherNetworkData))
            edit.apply()
            true
        } else {
            true
        }
    }
}