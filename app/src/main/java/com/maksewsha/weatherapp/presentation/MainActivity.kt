package com.maksewsha.weatherapp.presentation

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.maksewsha.weatherapp.R
import android.R as AR

class MainActivity : AppCompatActivity() {

    private var isSearchFragment = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.main_toolbar))
        supportActionBar!!.setHomeAsUpIndicator(AR.drawable.ic_menu_search)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        if (savedInstanceState == null){
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.main_container, MainWindowFragment())
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            AR.id.home -> {
                if (isSearchFragment) transitToMainWindowFragment() else transitToCitySettingsFragment()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun transitToCitySettingsFragment(){
        supportActionBar!!.setHomeAsUpIndicator(AR.drawable.ic_menu_revert)
        isSearchFragment = true
        supportFragmentManager.commit {
            replace(R.id.main_container, CitySettingsFragment())
            setReorderingAllowed(true)
            addToBackStack("CitySettings")
        }
    }

    private fun transitToMainWindowFragment(){
        supportActionBar!!.setHomeAsUpIndicator(AR.drawable.ic_menu_search)
        isSearchFragment = false
        supportFragmentManager.commit {
            replace(R.id.main_container, MainWindowFragment())
            setReorderingAllowed(false)
        }
    }
}