package com.maksewsha.weatherapp.presentation.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.maksewsha.weatherapp.data.CityRepositoryImpl
import com.maksewsha.weatherapp.data.storages.NetworkCityStorage
import com.maksewsha.weatherapp.data.storages.SharedPrefCityStorage
import com.maksewsha.weatherapp.domain.usecases.GetWeatherUseCase

class MainWindowFragmentViewModelFactory(private val context: Context) : ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainWindowFragmentViewModel(
            GetWeatherUseCase(
                CityRepositoryImpl(
                    NetworkCityStorage(),
                    SharedPrefCityStorage(context)
                )
            )
        ) as T
    }
}