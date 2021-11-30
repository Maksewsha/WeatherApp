package com.maksewsha.weatherapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.maksewsha.weatherapp.domain.usecases.GetWeatherUseCase
import com.maksewsha.weatherapp.presentation.models.CityWeatherInfoUI
import com.maksewsha.weatherapp.presentation.models.CityWeatherUI
import com.maksewsha.weatherapp.presentation.util.DomainToUIMapper

class MainWindowFragmentViewModel(private val getWeatherUseCase: GetWeatherUseCase) : ViewModel() {

    private val domainToUIMapper = DomainToUIMapper()

    private val error = MutableLiveData<Int>()
    val dataOnError = error as LiveData<Int>

    private val data = MutableLiveData<CityWeatherInfoUI>()
    val cityWeather = data as LiveData<CityWeatherInfoUI>

    fun getCityWeather(name: String){
        val gettedInfo = domainToUIMapper.mapFromEntity(getWeatherUseCase.getWeatherByName(name))
        when(gettedInfo){
            is CityWeatherUI.Success -> {
                data.value = gettedInfo.cityWeatherInfoUI
            }
            is CityWeatherUI.Fail -> {
                error.value = gettedInfo.message
            }
        }
    }
}