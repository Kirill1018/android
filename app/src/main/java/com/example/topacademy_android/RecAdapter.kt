package com.example.topacademy_android

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.topacademy_android.domLay
    .DataSeries
import com.google.gson.internal
    .LinkedTreeMap
import kotlin.collections.List

class RecAdapter(private var dataSer: List<DataSeries>, private val maud: Boolean) : RecyclerView.Adapter<RecAdapter.ViewHoldOfRec>() {
    inner class ViewHoldOfRec(private val binding: View) : RecyclerView.ViewHolder(binding.rootView) {
        fun bind(dataEp: DataSeries, maude: Boolean) {
            val tempText: TextView = binding.findViewById(R.id.temperature)
            val forecast: TextView = binding.findViewById(R.id.weather)
            val prediction: ImageView = binding.findViewById(R.id.predict)
            val heat = dataEp.temp2m//temperature
            val prognosis = dataEp.weather//weather
            val temp = "temperature: $heat"//content of text view of temperature
            val predict = "weather: $prognosis"//content of text view of weather
            val fever = heat as LinkedTreeMap<*, *>//changing value type
            val maxTemp = fever.values.elementAt(0).toString()
                .toDouble()//getting maximum temperature from tree map
            if (maude) {
                if (maxTemp >= 30) setCol(tempText, forecast, Color.rgb(255, 142, 0),
                    Color.CYAN)
                else if (maxTemp > 20) setCol(tempText, forecast, Color.rgb(18, 53, 36),
                    Color.MAGENTA)
                else setCol(tempText, forecast, Color.rgb(138, 43, 226),
                    Color.CYAN)
            }
            else {
                if (maxTemp >= 30) setCol(tempText, forecast, Color.RED,
                    Color.CYAN)
                else if (maxTemp > 20) setCol(tempText, forecast, Color.YELLOW,
                    Color.MAGENTA)
                else setCol(tempText, forecast, Color.BLUE,
                    Color.CYAN)
            }
            if (prognosis == "lightrain") prediction.setImageResource(R.drawable.lightrain)
            else if (prognosis == "cloudy") prediction.setImageResource(R.drawable.cloud)
            tempText.text = temp//setting content of text view of temperature
            forecast.text = predict//setting content of text view of weather
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoldOfRec {
        val binding = LayoutInflater.from(parent.context).inflate(R
            .layout.rec_it, parent, false)
        return ViewHoldOfRec(binding)
    }
    override fun onBindViewHolder(holder: ViewHoldOfRec, position: Int) = holder.bind(this.dataSer[position], this.maud)
    override fun getItemCount(): Int = this.dataSer.size
}
fun setCol(temperature: TextView, predict: TextView, tempCol: Int,
             progCol: Int) {
    temperature.setBackgroundColor(tempCol)
    temperature.setTextColor(progCol)
    predict.setBackgroundColor(tempCol)
    predict.setTextColor(progCol)
}