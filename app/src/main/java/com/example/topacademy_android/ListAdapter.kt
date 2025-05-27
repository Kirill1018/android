package com.example.topacademy_android

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class ListAdapter(context: Context, dataArrayList: ArrayList<Car?>?) : ArrayAdapter<Car?>(context, R.layout.list_it, dataArrayList!!) {
    override fun getView(position: Int, view: View?, parent: ViewGroup) : View {
        var type: View? = view//basic building block
        val listData = getItem(position)//type object in collection
        if (type == null) type = LayoutInflater.from(context).inflate(R.layout
            .list_it, parent, false)//creation view element from content of layout file
        val carBrand: TextView = type!!.findViewById(R.id.listBrand)//text display of car brand
        val carMod: TextView = type.findViewById(R.id.listMod)//text display of car model
        val carYear: TextView = type.findViewById(R.id.listYear)//text display of car year
        val carDescr: TextView = type.findViewById(R.id.listDescr)//text display of car description
        val carCost: TextView = type.findViewById(R.id.listCost)//text display of car cost
        val listImage: ImageView = type.findViewById(R.id.listIm)//image display
        carBrand.text = listData!!.brand//content of car brand
        carMod.text = listData.model//content of car model
        carYear.text = listData.year.toString()//content of car year
        carDescr.text = listData.description//content of car description
        carCost.text = listData.cost.toString()//content of car cost
        listImage.setImageResource(listData.imageResId)
        return type
    }
}