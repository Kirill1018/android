package com.example.topacademy_android

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val calcButt: MaterialButton = findViewById(R.id.calcButt)
        val listButt: MaterialButton = findViewById(R.id.listButt)
        val weather: MaterialButton = findViewById(R.id.weather)
        calcButt.setOnClickListener { startActivity(Intent(this, Calculator::class.java).apply {  }) }
        listButt.setOnClickListener { startActivity(Intent(this, List::class.java).apply {  }) }
        weather.setOnClickListener { startActivity(Intent(this, Weather::class.java).apply {  }) }
    }
}