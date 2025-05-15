package com.example.topacademy_android

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.topacademy_android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.i(null, "program's created")
    }
    override fun onStart() {
        super.onStart()
        Log.i(null, "program's started")
    }
    override fun onRestart() {
        super.onRestart()
        Log.i(null, "program's restarted")
    }
    override fun onResume() {
        super.onResume()
        Log.i(null, "program's resumed")
    }
    override fun onPause() {
        super.onPause()
        Log.i(null, "program's paused")
    }
    override fun onStop() {
        super.onStop()
        Log.i(null, "program's stopped")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.i(null, "program's destroyed")
    }
}