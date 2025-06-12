package com.example.topacademy_android

import android.os.Bundle
import android.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.topacademy_android.domain
    .model.Car
import com.example.topacademy_android.presentation
    .screen.CarAdapter

class List : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val firstCar = Car("car 1", "n9", 2025,
            "cvt", 7399000, R.drawable.car1)//data object of first car
        val secCar = Car("car 2", "m7", 2024,
            "automatic transmission", 5250000, R.drawable.car2)
        val thirdCar = Car("car 3", "l6", 2024,
            "automatic transmission", 4424000, R.drawable.car3)
        val cars = ArrayList<Car>()
        cars.add(firstCar)
        cars.add(secCar)
        cars.add(thirdCar)
        val carAdapter = CarAdapter(cars.toList())//broker between ui component and data source
        val recycler: RecyclerView = findViewById(R.id.machines)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = carAdapter
        val toolBar: Toolbar = findViewById(R.id.tools)
        toolBar.setNavigationOnClickListener { finish() }
    }
}