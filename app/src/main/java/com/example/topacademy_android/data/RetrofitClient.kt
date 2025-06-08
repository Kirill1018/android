package com.example.topacademy_android.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "http://www.7timer.info/"
    val weatherApi: WeatherApi by lazy { Retrofit.Builder().baseUrl(this.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).client(OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()).build().create(WeatherApi::class.java) }
}