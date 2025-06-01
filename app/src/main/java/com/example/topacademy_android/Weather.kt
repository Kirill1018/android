package com.example.topacademy_android

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.topacademy_android.dataLay
    .RetrofitClient
import com.example.topacademy_android.domLay
    .WeatherResponse
import com.google.android.material
    .materialswitch.MaterialSwitch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Weather : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_weather)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val retButt: Button = findViewById(R.id.backButt)
        retButt.setOnClickListener { startActivity(Intent(this, HomeActivity::class.java)) }
        val recycler: RecyclerView = findViewById(R.id.recView)//flexible module and productive component for display lists
        recycler.layoutManager = LinearLayoutManager(this)//element placement
        val nightMode = AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES//check mode
        val modeSwitch: MaterialSwitch = findViewById(R.id.vogue)
        modeSwitch.setOnClickListener {
            if (modeSwitch.isChecked) changeTheme(AppCompatDelegate.MODE_NIGHT_YES, recycler)
            else changeTheme(AppCompatDelegate.MODE_NIGHT_NO, recycler)
        }
        fetchWeather(latitude = 23.09, longitude = 113.17, recycler,
            nightMode)
    }
}
fun fetchWeather(latitude: Double, longitude: Double, recBoil: RecyclerView,
                 mode: Boolean) {
    val call = RetrofitClient.weatherApi.weatherForecast(latitude = latitude, longitude = longitude)//invocation of a retrofit method that sends a request to a webserver and returns a response
    call.enqueue(object: Callback<WeatherResponse> {
        override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
            if (response.isSuccessful) {
                val weatherData = response.body()//response
                val series = weatherData?.dataseries//data series
                val adapter = RecAdapter(series!!, mode)//broker between ui component and data source
                recBoil.adapter = adapter//directing data source
            }
            else println("error: ${response.code()}")
        }
        override fun onFailure(call: Call<WeatherResponse>, t: Throwable) = println("network error: ${t.message}")
    })
}
fun changeTheme(theme: Int, boiler: RecyclerView) {
    AppCompatDelegate.setDefaultNightMode(theme)
    val isNight = AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES//check mode
    fetchWeather(latitude = 23.09, longitude = 113.17, boiler,
        isNight)
}