package com.example.topacademy_android.data.local

import android.widget.TextView
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatDelegate
import com.example.topacademy_android.CalcFragment
import com.example.topacademy_android.R
import com.example.topacademy_android.domain
    .model.Element
import com.google.android.material
    .button.MaterialButton
import com.google.android.material
    .materialswitch.MaterialSwitch

object Calculator {
    fun load(calcFragment: CalcFragment) {
        val view = calcFragment.view
        val matSwitch: MaterialSwitch? = view?.findViewById(R.id.mode)//material themed switch
        matSwitch?.setOnClickListener {
            if (matSwitch.isChecked) AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
        val toolBar: Toolbar? = view?.findViewById(Element.tools)
        val requireActivity = calcFragment.requireActivity()
        toolBar?.setNavigationOnClickListener { goBack(requireActivity) }
        val clearKey: MaterialButton? = view?.findViewById(R.id.clear)
        val backKey: MaterialButton? = view?.findViewById(R.id.backward)
        val percKey: MaterialButton? = view?.findViewById(R.id.percent)
        val divKey: MaterialButton? = view?.findViewById(R.id.division)
        val sevKey: MaterialButton? = view?.findViewById(R.id.seven)
        val eightKey: MaterialButton? = view?.findViewById(R.id.eight)
        val nineKey: MaterialButton? = view?.findViewById(R.id.nine)
        val multiplier: MaterialButton? = view?.findViewById(R.id.multiplication)
        val fourKey: MaterialButton? = view?.findViewById(R.id.four)
        val fiveKey: MaterialButton? = view?.findViewById(R.id.five)
        val sixKey: MaterialButton? = view?.findViewById(R.id.six)
        val dedKey: MaterialButton? = view?.findViewById(R.id.subtracting)
        val oneKey: MaterialButton? = view?.findViewById(R.id.one)
        val twoKey: MaterialButton? = view?.findViewById(R.id.two)
        val threeKey: MaterialButton? = view?.findViewById(R.id.three)
        val addKey: MaterialButton? = view?.findViewById(R.id.addition)
        val zeroKey: MaterialButton? = view?.findViewById(R.id.zero)
        val dotKey: MaterialButton? = view?.findViewById(R.id.dot)
        val keyOfChangSign: MaterialButton? = view?.findViewById(R.id.changSign)
        val resSign: MaterialButton? = view?.findViewById(R.id.result)
        val effect: TextView? = view?.findViewById(R.id.outcome)
        var output = String()
        clearKey?.setOnClickListener {
            output = String()
            effect?.text = output
        }
        backKey?.setOnClickListener { if (output != String()) {
            val finding = output.toMutableList()
            finding.removeAt(finding.size - 1)
            output = String()
            var i = 0
            while (i < finding.size) {
                output += finding[i]
                i++
            }
            effect?.text = output
        }
        }
        percKey?.setOnClickListener {
            output += "%"
            effect?.text = output
        }
        divKey?.setOnClickListener {
            output += "/"
            effect?.text = output
        }
        sevKey?.setOnClickListener {
            output += "7"
            effect?.text = output
        }
        eightKey?.setOnClickListener {
            output += "8"
            effect?.text = output
        }
        nineKey?.setOnClickListener {
            output += "9"
            effect?.text = output
        }
        multiplier?.setOnClickListener {
            output += "*"
            effect?.text = output
        }
        fourKey?.setOnClickListener {
            output += "4"
            effect?.text = output
        }
        fiveKey?.setOnClickListener {
            output += "5"
            effect?.text = output
        }
        sixKey?.setOnClickListener {
            output += "6"
            effect?.text = output
        }
        dedKey?.setOnClickListener {
            output += "-"
            effect?.text = output
        }
        oneKey?.setOnClickListener {
            output += "1"
            effect?.text = output
        }
        twoKey?.setOnClickListener {
            output += "2"
            effect?.text = output
        }
        threeKey?.setOnClickListener {
            output += "3"
            effect?.text = output
        }
        addKey?.setOnClickListener {
            output += "+"
            effect?.text = output
        }
        zeroKey?.setOnClickListener {
            output += "0"
            effect?.text = output
        }
        dotKey?.setOnClickListener {
            output += "."
            effect?.text = output
        }
        keyOfChangSign?.setOnClickListener {
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
                effect?.text = output
            }
        }
        resSign?.setOnClickListener {
            val viewModelOfCalc = calcFragment.viewModelOfCalc
            viewModelOfCalc.solve(output)
            effect?.text = viewModelOfCalc.outcome
            output = String()
        }
    }
}