package com.example.topacademy_android

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.topacademy_android.domLay
    .Car

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
            "automatic transmission", 5250000, R.drawable.car2)//data object of second car
        val thirdCar = Car("car 3", "l6", 2024,
            "automatic transmission", 4424000, R.drawable.car3)//data object of third car
        val cars = ArrayList<Car>()//car collection
        cars.add(firstCar)
        cars.add(secCar)
        cars.add(thirdCar)
        val carAdapter = CarAdapter(cars.toList())//broker between ui component and data source
        val recycler: RecyclerView = findViewById(R.id.machines)//scrollable items
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = carAdapter//filling data
        val retButt: Button = findViewById(R.id.backButt)
        retButt.setOnClickListener { startActivity(Intent(this, HomeActivity::class.java)) }
    }
}