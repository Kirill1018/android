package com.example.topacademy_android.presentation.viewmodel

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView
import com.example.topacademy_android.MainActivity
import com.example.topacademy_android.domain
    .model.WeatherResponse
import com.example.topacademy_android.data
    .remote.RecAdapter
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelOfWeather : ViewModel() {
    fun fetchWeather(latitude: Double, longitude: Double, recBoil: RecyclerView,
                     mode: Boolean, activity: FragmentActivity) = viewModelScope.launch {
                         val mainActivity = activity as MainActivity
        val call = mainActivity.weatherAdapter.getWeatherApi().weatherForecast(latitude = latitude, longitude = longitude)//invocation of a retrofit method that sends a request to a webserver and returns a response
        call.enqueue(object: Callback<WeatherResponse> {
            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) { if (response.isSuccessful) {
                val weatherData = response.body()//response
                val series = weatherData?.dataseries
                val adapter = RecAdapter(series!!, mode)
                recBoil.adapter = adapter
            }
            }
            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) { }
        })
    }
}