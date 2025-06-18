package com.example.topacademy_android.data.local

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.topacademy_android.R
import com.example.topacademy_android.domain
    .model.Car
import com.google.android.material
    .imageview.ShapeableImageView

class CarAdapter(private var machines: List<Car>) : RecyclerView.Adapter<CarAdapter.ViewHoldOfCar>() {
    inner class ViewHoldOfCar(private val binding: View) : RecyclerView.ViewHolder(binding.rootView) {
        fun bind(machine: Car) {
            val brand: TextView = this.binding.findViewById(R.id
                .listBrand)
            val model: TextView = this.binding.findViewById(R.id
                .listMod)
            val year: TextView = this.binding.findViewById(R.id
                .listYear)
            val description: TextView = this.binding.findViewById(R.id
                .listDescr)
            val cost: TextView = this.binding.findViewById(R.id
                .listCost)
            val image: ShapeableImageView = this.binding.findViewById(R.id
                .listIm)
            brand.text = machine.brand
            model.text = machine.model
            year.text = machine.year.toString()
            description.text = machine.description
            cost.text = machine.cost.toString()
            image.setImageResource(machine.imageResId)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoldOfCar {
        val binding = LayoutInflater.from(parent.context).inflate(R
            .layout.list_it, parent, false)
        return ViewHoldOfCar(binding)
    }
    override fun onBindViewHolder(holder: ViewHoldOfCar, position: Int) = holder.bind(this.machines[position])
    override fun getItemCount(): Int = this.machines.size
}