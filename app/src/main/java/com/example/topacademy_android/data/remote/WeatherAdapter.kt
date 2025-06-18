package com.example.topacademy_android.data.remote

import com.example.topacademy_android.data
    .repository.WeatherApi
import javax.inject.Inject

class WeatherAdapter @Inject constructor(private val service: WeatherApi) {
    fun getWeatherApi() = this.service
}