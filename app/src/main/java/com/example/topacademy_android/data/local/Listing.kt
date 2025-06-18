package com.example.topacademy_android.data.local

import android.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.topacademy_android.ListFragment
import com.example.topacademy_android.R
import com.example.topacademy_android.domain
    .model.Car
import com.example.topacademy_android.domain
    .model.Element

object Listing {
    fun load(listFragment: ListFragment) {
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
        val view = listFragment.view
        val recycler: RecyclerView? = view?.findViewById(R.id.machines)
        val requireActivity = listFragment.requireActivity()
        recycler?.layoutManager = LinearLayoutManager(requireActivity)
        recycler?.adapter = carAdapter
        val toolBar: Toolbar? = view?.findViewById(Element.tools)
        toolBar?.setNavigationOnClickListener { goBack(requireActivity) }
    }
}