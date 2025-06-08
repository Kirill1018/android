package com.example.topacademy_android.domain

data class WeatherResponse (
    val product: String,
    val init: String,
    val dataseries: List<DataSeries>
)