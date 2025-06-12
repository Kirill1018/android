package com.example.topacademy_android.domain.model

data class WeatherResponse (
    val product: String,
    val init: String,
    val dataseries: List<DataSeries>
)