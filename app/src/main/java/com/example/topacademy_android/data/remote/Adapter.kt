package com.example.topacademy_android.data.remote

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.topacademy_android.R
import com.example.topacademy_android.data
    .local.setCol
import com.example.topacademy_android.domain
    .model.DataSeries
import com.google.gson.internal
    .LinkedTreeMap
import kotlin.collections.List

class RecAdapter(private var dataSer: List<DataSeries>, private val maud: Boolean) : RecyclerView.Adapter<RecAdapter.ViewHoldOfRec>() {
    inner class ViewHoldOfRec(private val binding: View) : RecyclerView.ViewHolder(binding.rootView) {
        fun bind(dataEp: DataSeries, maude: Boolean) {
            val textOfMaxTemp: TextView = this.binding.findViewById(R.id
                .maxTemp)
            val textOfMinTemp: TextView = this.binding.findViewById(R.id
                .minTemp)
            val forecast: TextView = this.binding.findViewById(R.id
                .weather)
            val prediction: ImageView = this.binding.findViewById(R.id
                .predict)
            val prognosis = dataEp.weather//weather
            val fever = dataEp.temp2m as LinkedTreeMap<*, *>
            val significances = fever.values
            val maxTemp = significances.elementAt(0).toString().toDouble()
            val minTemp = significances.elementAt(1).toString().toDouble()
            val topTemp = "maximum temperature: $maxTemp"
            val lowTemp = "minimum temperature: $minTemp"
            val predict = "weather: $prognosis"
            val cyanCol = Color.CYAN
            val magCol = Color.MAGENTA
            if (maude) {
                if (maxTemp >= 30) setCol(textOfMaxTemp, textOfMinTemp, forecast,
                    Color.rgb(255, 142, 0), cyanCol)
                else if (maxTemp > 20) setCol(textOfMaxTemp, textOfMinTemp, forecast,
                    Color.rgb(18, 53, 36), magCol)
                else setCol(textOfMaxTemp, textOfMinTemp, forecast,
                    Color.rgb(138, 43, 226), cyanCol)
            }
            else {
                if (maxTemp >= 30) setCol(textOfMaxTemp, textOfMinTemp, forecast,
                    Color.RED, cyanCol)
                else if (maxTemp > 20) setCol(textOfMaxTemp, textOfMinTemp, forecast,
                    Color.YELLOW, magCol)
                else setCol(textOfMaxTemp, textOfMinTemp, forecast,
                    Color.BLUE, cyanCol)
            }
            if (prognosis == "lightrain") prediction.setImageResource(R.drawable.lightrain)
            else if (prognosis == "cloudy") prediction.setImageResource(R.drawable.cloud)
            else if (prognosis == "ishower") prediction.setImageResource(R.drawable.ishower)
            else if (prognosis == "pcloudy") prediction.setImageResource(R.drawable.pcloudy)
            textOfMaxTemp.text = topTemp
            textOfMinTemp.text = lowTemp
            forecast.text = predict
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