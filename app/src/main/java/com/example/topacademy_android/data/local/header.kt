package com.example.topacademy_android.data.local

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.util.TypedValue
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.topacademy_android.WeatherFragment

fun roundedCornerDrawable(borderWidth: Int = 10, borderColor: Int = Color.DKGRAY, cornerRadius: Float = 25F,
                          bgColor: Int = Color.LTGRAY): Drawable = GradientDrawable().apply {
                              shape = GradientDrawable.RECTANGLE
    setStroke(borderWidth, borderColor)
    setColor(bgColor)
    this.cornerRadius = cornerRadius
                          }
fun Int.dpToPixels(context: Context): Int = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this
    .toFloat(), context.resources.displayMetrics).toInt()

fun changeTheme(theme: Int, boiler: RecyclerView, partAct: FragmentActivity,
                weatherFragment: WeatherFragment) {
    AppCompatDelegate.setDefaultNightMode(theme)
    val isNight = AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES//check mode
    weatherFragment.viewModelOfWeather.fetchWeather(latitude = 23.09, longitude = 113.17, boiler,
        isNight, partAct)
}
fun goBack(fragmentActivity: FragmentActivity) {
    val suppPartMan = fragmentActivity.supportFragmentManager
    suppPartMan.popBackStackImmediate()
    suppPartMan.beginTransaction().commit()
}
fun setCol(heat: TextView, coldTemp: TextView, predict: TextView,
           tempCol: Int, progCol: Int) {
    heat.setBackgroundColor(tempCol)
    heat.setTextColor(progCol)
    coldTemp.setBackgroundColor(tempCol)
    coldTemp.setTextColor(progCol)
    predict.setBackgroundColor(tempCol)
    predict.setTextColor(progCol)
}