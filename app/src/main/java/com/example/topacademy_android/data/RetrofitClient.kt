package com.example.topacademy_android.data

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components
    .ActivityComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
@Module
@InstallIn(ActivityComponent::class)
object RetrofitClient {
    private const val BASE_URL = "http://www.7timer.info/"
    @Provides
    fun weatherApi(): WeatherApi = Retrofit.Builder().baseUrl(this.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).client(OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()).build().create(WeatherApi::class.java)
}