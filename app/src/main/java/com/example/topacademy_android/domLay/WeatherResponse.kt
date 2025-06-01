package com.example.topacademy_android.domLay

data class WeatherResponse (
    val product: String,
    val init: String,
    val dataseries: List<DataSeries>
)