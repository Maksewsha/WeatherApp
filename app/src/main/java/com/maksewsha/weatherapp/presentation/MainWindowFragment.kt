package com.maksewsha.weatherapp.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.maksewsha.weatherapp.R
import com.maksewsha.weatherapp.presentation.viewmodels.MainWindowFragmentViewModel
import com.maksewsha.weatherapp.presentation.viewmodels.MainWindowFragmentViewModelFactory

class MainWindowFragment : Fragment(R.layout.fragment_main_window) {

    private val viewModel by lazy {
        ViewModelProvider(this, MainWindowFragmentViewModelFactory(this as Context)).get(MainWindowFragmentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return super.onCreateView(inflater, container, savedInstanceState)
    }
}