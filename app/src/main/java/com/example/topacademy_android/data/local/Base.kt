package com.example.topacademy_android.data.local

import android.widget.EditText
import android.widget.TextView
import androidx.core.view.isVisible
import com.example.topacademy_android.MainFragment
import com.example.topacademy_android.R
import com.example.topacademy_android.domain
    .model.Element
import com.google.android.material
    .bottomnavigation.BottomNavigationView
import com.google.android.material
    .button.MaterialButton

object Base {
    fun load(mainFragment: MainFragment) {
        val view = mainFragment.view
        val entryText: TextView? = view?.findViewById(R.id.enter)
        val matButt: MaterialButton? = view?.findViewById(R.id.material)
        val requireActivity = mainFragment.requireActivity()
        val bottomNavigationView: BottomNavigationView = requireActivity.findViewById(Element.navigation)
        val enter = requireActivity.getText(R.string.accEnt)
        if (mainFragment.isEnt) {
            bottomNavigationView.isVisible = true
            entryText?.text = enter
        }
        else bottomNavigationView.isVisible = false
        matButt?.setOnClickListener {
            mainFragment.isEnt = true
            bottomNavigationView.isVisible = true
            entryText?.text = enter
        }
        val edText1: EditText? = view?.findViewById(R.id.login)//password overlay over text view that configures itself to be editable
        val edText2: EditText? = view?.findViewById(R.id.passphrase)
        val bordRadOfEdText = 2
        val cornRadOfEdText = 10
        val appCont = requireActivity.applicationContext
        edText1?.background = roundedCornerDrawable(bordRadOfEdText.dpToPixels(appCont), R.color
            .darkScarlet, cornRadOfEdText.dpToPixels(appCont).toFloat())
        edText2?.background = roundedCornerDrawable(borderWidth = bordRadOfEdText, borderColor = R.color.carmine, cornerRadius = cornRadOfEdText
            .dpToPixels(appCont).toFloat(), bgColor = R.color.wheat)
    }
}