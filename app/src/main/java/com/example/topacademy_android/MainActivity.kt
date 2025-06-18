package com.example.topacademy_android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.topacademy_android.data
    .local.Loading
import com.example.topacademy_android.data
    .remote.WeatherAdapter
import com.example.topacademy_android.databinding
    .ActivityMainBinding
import com.example.topacademy_android.domain
    .model.Element
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    @Inject lateinit var weatherAdapter: WeatherAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Loading.load(this)
    }
    override fun onSupportNavigateUp(): Boolean = findNavController(Element.navigation).navigateUp()
}