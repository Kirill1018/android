package com.example.topacademy_android

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.topacademy_android.domLay
    .Car
import com.google.android.material
    .imageview.ShapeableImageView
import kotlin.collections.List

class CarAdapter(private var machines: List<Car>) : RecyclerView.Adapter<CarAdapter.ViewHoldOfCar>() {
    inner class ViewHoldOfCar(private val binding: View) : RecyclerView.ViewHolder(binding.rootView) {
        fun bind(machine: Car) {
            val brand: TextView = binding.findViewById(R.id.listBrand)
            val model: TextView = binding.findViewById(R.id.listMod)
            val year: TextView = binding.findViewById(R.id.listYear)
            val description: TextView = binding.findViewById(R.id.listDescr)
            val cost: TextView = binding.findViewById(R.id.listCost)
            val image: ShapeableImageView = binding.findViewById(R.id.listIm)
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