package com.example.topacademy_android.data.repository

import com.example.topacademy_android.domain
    .model.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("bin/api.pl")
    fun weatherForecast(@Query("lon") longitude: Double, @Query("lat") latitude: Double,
                        @Query("product") product: String = "civillight", @Query("output") output: String = "json"): Call<WeatherResponse>
}