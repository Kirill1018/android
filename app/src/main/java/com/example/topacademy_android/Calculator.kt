package com.example.topacademy_android

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material
    .button.MaterialButton
import com.google.android.material
    .materialswitch.MaterialSwitch

class Calculator : AppCompatActivity() {
    private val viewModelOfCalc: ViewModelOfCalc by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculator)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val matSwitch: MaterialSwitch = findViewById(R.id.mode)//material themed switch
        matSwitch.setOnClickListener {
            if (matSwitch.isChecked) AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
        val toolBar: Toolbar = findViewById(R.id.tools)
        toolBar.setNavigationOnClickListener { startActivity(Intent(this, HomeActivity::class.java)) }
        val clearKey: MaterialButton = findViewById(R.id.clear)
        val backKey: MaterialButton = findViewById(R.id.backward)
        val percKey: MaterialButton = findViewById(R.id.percent)
        val divKey: MaterialButton = findViewById(R.id.division)
        val sevKey: MaterialButton = findViewById(R.id.seven)
        val eightKey: MaterialButton = findViewById(R.id.eight)
        val nineKey: MaterialButton = findViewById(R.id.nine)
        val multiplier: MaterialButton = findViewById(R.id.multiplication)
        val fourKey: MaterialButton = findViewById(R.id.four)
        val fiveKey: MaterialButton = findViewById(R.id.five)
        val sixKey: MaterialButton = findViewById(R.id.six)
        val dedKey: MaterialButton = findViewById(R.id.substracting)
        val oneKey: MaterialButton = findViewById(R.id.one)
        val twoKey: MaterialButton = findViewById(R.id.two)
        val threeKey: MaterialButton = findViewById(R.id.three)
        val addKey: MaterialButton = findViewById(R.id.addition)
        val zeroKey: MaterialButton = findViewById(R.id.zero)
        val dotKey: MaterialButton = findViewById(R.id.dot)
        val keyOfChangSign: MaterialButton = findViewById(R.id.changSign)
        val resSign: MaterialButton = findViewById(R.id.result)
        val effect: TextView = findViewById(R.id.outcome)
        var output = String()
        clearKey.setOnClickListener {
            output = String()
            effect.text = output
        }
        backKey.setOnClickListener { if (output != String()) {
            val finding = output.toMutableList()
            finding.removeAt(finding.size - 1)
            output = String()
            var i = 0
            while (i < finding.size) {
                output += finding[i]
                i++
            }
            effect.text = output
        }
        }
        percKey.setOnClickListener {
            output += "%"
            effect.text = output
        }
        divKey.setOnClickListener {
            output += "/"
            effect.text = output
        }
        sevKey.setOnClickListener {
            output += "7"
            effect.text = output
        }
        eightKey.setOnClickListener {
            output += "8"
            effect.text = output
        }
        nineKey.setOnClickListener {
            output += "9"
            effect.text = output
        }
        multiplier.setOnClickListener {
            output += "*"
            effect.text = output
        }
        fourKey.setOnClickListener {
            output += "4"
            effect.text = output
        }
        fiveKey.setOnClickListener {
            output += "5"
            effect.text = output
        }
        sixKey.setOnClickListener {
            output += "6"
            effect.text = output
        }
        dedKey.setOnClickListener {
            output += "-"
            effect.text = output
        }
        oneKey.setOnClickListener {
            output += "1"
            effect.text = output
        }
        twoKey.setOnClickListener {
            output += "2"
            effect.text = output
        }
        threeKey.setOnClickListener {
            output += "3"
            effect.text = output
        }
        addKey.setOnClickListener {
            output += "+"
            effect.text = output
        }
        zeroKey.setOnClickListener {
            output += "0"
            effect.text = output
        }
        dotKey.setOnClickListener {
            output += "."
            effect.text = output
        }
        keyOfChangSign.setOnClickListener {
            val finding = output.split("/", "*", "-",
                "+", "%")
            val lastNumb = finding[finding.size - 1]
            val countOfLastNumb = lastNumb.count()
            if (countOfLastNumb > 0) {
                val expression = output.toMutableList()
                var i = countOfLastNumb - 1
                while (i >= 0) {
                    expression.removeAt(expression.size - 1 - i)
                    i--
                }
                val number = lastNumb.toMutableList()
                number.add(0, '(')
                number.add(1, '-')
                number.add(')')
                var x = 0
                while (x < number.size) {
                    expression.add(number[x])
                    x++
                }
                output = String()
                var y = 0
                while (y < expression.size) {
                    output += expression[y]
                    y++
                }
                effect.text = output
            }
        }
        resSign.setOnClickListener {
            this.viewModelOfCalc.solve(output)
            this.viewModelOfCalc.getEx.observe(this) { solution -> effect
                .text = solution }
            output = String()
        }
    }
}