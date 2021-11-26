package com.maksewsha.weatherapp.data.storages

import android.content.Context
import com.maksewsha.weatherapp.data.models.CityWeatherData

class SharedPrefCityStorage(context: Context) : CityStorage {

    companion object{
        private const val KEY_PREFS_CITY_LIST = "cityListPrefs"
    }

    private val sharedPrefs = context.getSharedPreferences(KEY_PREFS_CITY_LIST, Context.MODE_PRIVATE)

    override fun fetchById(id: Int): CityWeatherData {
        TODO("Not yet implemented")
    }

    override fun save(cityWeatherData: CityWeatherData): Boolean {
        TODO("Not yet implemented")
    }
}