package com.maksewsha.weatherapp.presentation

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.maksewsha.weatherapp.R
import com.maksewsha.weatherapp.presentation.viewmodels.MainWindowFragmentViewModel
import com.maksewsha.weatherapp.presentation.viewmodels.MainWindowFragmentViewModelFactory

class MainWindowFragment : Fragment(R.layout.fragment_main_window) {

    private lateinit var viewModel: MainWindowFragmentViewModel

    private lateinit var textViewCityName: TextView
    private lateinit var textViewCityDegrees: TextView
    private lateinit var editTextCityInput: EditText
    private lateinit var buttonSearch: Button
    private lateinit var textViewDescription: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this, MainWindowFragmentViewModelFactory(context as Context)).get(MainWindowFragmentViewModel::class.java)

        textViewCityName = view.findViewById(R.id.fr_main_window_city_name)
        textViewCityDegrees = view.findViewById(R.id.fr_main_window_degrees)
        textViewDescription = view.findViewById(R.id.fr_main_window_description)
        editTextCityInput = view.findViewById(R.id.fr_main_window_city_input)
        buttonSearch = view.findViewById(R.id.fr_main_window_btn_search)


        viewModel.cityWeather.observe(this, {
            textViewCityName.text = "${it.name}, ${it.country}"
            textViewCityDegrees.text = it.tempCelsius.toString()
            textViewDescription.text  = it.description
        })

        viewModel.dataOnError.observe(this, {
            Snackbar.make(view, context!!.getString(it), Snackbar.LENGTH_SHORT).show()
        })

        buttonSearch.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                viewModel.getCityWeather(editTextCityInput.text.toString())
            }
        })

        super.onViewCreated(view, savedInstanceState)
    }
}