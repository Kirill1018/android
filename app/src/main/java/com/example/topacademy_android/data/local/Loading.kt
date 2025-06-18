package com.example.topacademy_android.data.local

import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.topacademy_android.MainActivity
import com.example.topacademy_android.data
    .remote.RetrofitClient
import com.example.topacademy_android.data
    .remote.WeatherAdapter
import com.example.topacademy_android.domain
    .model.Element
import com.google.android.material
    .bottomnavigation.BottomNavigationView

object Loading {
    fun load(mainActivity: MainActivity) {
        val navHostFragment = mainActivity.supportFragmentManager.findFragmentById(Element.fragment)
        var navController: NavController? = null
        if (navHostFragment != null) navController = navHostFragment.findNavController()
        val toolbar: androidx.appcompat.widget.Toolbar = mainActivity
            .findViewById(Element.tools)
        mainActivity.setSupportActionBar(toolbar)
        mainActivity.setupActionBarWithNavController(navController!!)
        val bottomNav: BottomNavigationView = mainActivity.findViewById(Element.navigation)
        bottomNav.setupWithNavController(navController)
        mainActivity.weatherAdapter = WeatherAdapter(RetrofitClient.weatherApi())
    }
}