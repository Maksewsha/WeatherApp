package com.maksewsha.weatherapp.data.storages

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.maksewsha.weatherapp.data.models.CityWeatherData

class SharedPrefCityStorage(context: Context) : CityStorage {

    companion object{
        private const val KEY_PREFS_CITY_LIST = "cityListPrefs"
        private val gson = Gson()
    }

    private val sharedPrefs = context.getSharedPreferences(KEY_PREFS_CITY_LIST, Context.MODE_PRIVATE)

    override fun getByName(name: String): CityWeatherData?{
        return if (sharedPrefs.contains("$name")){
            val data = sharedPrefs.getString("$name", "")
            gson.fromJson(data!!.reader(), CityWeatherData::class.java)
        } else {
            null
        }
    }

    override fun save(cityWeatherData: CityWeatherData): Boolean {
        return if (!sharedPrefs.contains("${cityWeatherData.id}")){
            val edit = sharedPrefs.edit()
            edit.putString("${cityWeatherData.id}", gson.toJson(cityWeatherData))
            edit.apply()
            true
        } else {
            true
        }
    }
}