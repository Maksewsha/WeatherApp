package com.maksewsha.weatherapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.maksewsha.weatherapp.domain.models.CityWeatherDomain
import com.maksewsha.weatherapp.domain.models.CityWeatherInfoDomain
import com.maksewsha.weatherapp.domain.usecases.GetWeatherUseCase

class MainWindowFragmentViewModel(private val getWeatherUseCase: GetWeatherUseCase) : ViewModel() {

    private val error = MutableLiveData<Exception>()
    val errorOnIncorrectName = error as LiveData<Exception>

    private val data = MutableLiveData<CityWeatherInfoDomain>()
    val cityWeather = data as LiveData<CityWeatherInfoDomain>

    fun getCityWeather(name: String){
        val gettedInfo = getWeatherUseCase.getWeatherByName(name)
        when(gettedInfo){
            is CityWeatherDomain.Success -> {
                data.value = gettedInfo.cityWeatherInfoDomain
            }
            is CityWeatherDomain.Fail -> {
                error.value = gettedInfo.exception
            }
        }
    }
}