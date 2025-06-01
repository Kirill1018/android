package com.example.topacademy_android

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.util.TypedValue
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.topacademy_android.databinding
    .ActivityMainBinding
import com.google.android.material
    .button.MaterialButton

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val matButt: MaterialButton = findViewById(R.id.material)
        matButt.setOnClickListener { startActivity(Intent(this, HomeActivity::class.java).apply {  }) }
        val edText1: EditText = findViewById(R.id.login)//password overlay over text view that configures itself to be editable
        val edText2: EditText = findViewById(R.id.passphrase)//login overlay over text view that configures itself to be editable
        val bordRadOfEdText = 2//boundary radius of edit text
        val cornRadOfEdText = 10//nook radius of edit text
        edText1.background = roundedCornerDrawable(bordRadOfEdText.dpToPixels(applicationContext), R.color
            .darkScar, cornRadOfEdText.dpToPixels(applicationContext).toFloat())//background of first text of editing
        edText2.background = roundedCornerDrawable(borderWidth = bordRadOfEdText, borderColor = R.color.carmine, cornerRadius = cornRadOfEdText
            .dpToPixels(applicationContext).toFloat(), bgColor = R.color.wheat)//background of second text of editing
    }
}
fun roundedCornerDrawable(borderWidth: Int = 10, borderColor: Int = Color.DKGRAY, cornerRadius: Float = 25F,
                          bgColor: Int = Color.LTGRAY): Drawable {
    return GradientDrawable().apply { shape = GradientDrawable.RECTANGLE//drawable with color gradient
        setStroke(borderWidth, borderColor)//only shape border
        setColor(bgColor)//color definition
        this.cornerRadius = cornerRadius//nook radius
    }
}
fun Int.dpToPixels(context: Context): Int = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this
    .toFloat(), context.resources.displayMetrics).toInt()