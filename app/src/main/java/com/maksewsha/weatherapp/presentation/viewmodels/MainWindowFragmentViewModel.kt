package com.maksewsha.weatherapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.maksewsha.weatherapp.domain.models.CityWeatherDomain
import com.maksewsha.weatherapp.domain.usecases.GetWeatherUseCase

class MainWindowFragmentViewModel(private val getWeatherUseCase: GetWeatherUseCase) : ViewModel() {

    private val data = MutableLiveData<CityWeatherDomain>()
    val cityWeather = data as LiveData<CityWeatherDomain>

    fun getCityWeather(id: Int){
        data.value = getWeatherUseCase.getWeatherById(id)
    }
}