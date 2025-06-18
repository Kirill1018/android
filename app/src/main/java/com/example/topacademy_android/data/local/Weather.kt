package com.example.topacademy_android.data.local

import android.widget.Toolbar
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.topacademy_android.R
import com.example.topacademy_android.WeatherFragment
import com.example.topacademy_android.domain
    .model.Element
import com.google.android.material
    .materialswitch.MaterialSwitch

object Weather {
    fun load(weatherFragment: WeatherFragment) {
        val view = weatherFragment.view
        val toolBar: Toolbar? = view?.findViewById(Element.tools)
        val requireActivity = weatherFragment.requireActivity()
        toolBar?.setNavigationOnClickListener { goBack(requireActivity) }
        val recycler: RecyclerView? = view?.findViewById(R.id.recView)//flexible module and productive component for display lists
        recycler?.layoutManager = LinearLayoutManager(requireActivity)
        val nightMode = AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES
        val modeSwitch: MaterialSwitch? = view?.findViewById(R.id.vogue)
        modeSwitch?.setOnClickListener {
            if (modeSwitch.isChecked) changeTheme(AppCompatDelegate.MODE_NIGHT_YES, recycler!!, requireActivity,
                weatherFragment)
            else changeTheme(AppCompatDelegate.MODE_NIGHT_NO, recycler!!, requireActivity,
                weatherFragment)
        }
        weatherFragment.viewModelOfWeather.fetchWeather(latitude = 23.09, longitude = 113.17, recycler!!,
            nightMode, requireActivity)
    }
}