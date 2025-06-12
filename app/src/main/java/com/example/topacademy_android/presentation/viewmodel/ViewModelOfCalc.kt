package com.example.topacademy_android.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.topacademy_android.domain
    .usecase.GetUseCaseOfRes

class ViewModelOfCalc: ViewModel() {
    var outcome = String()
    fun solve(example: String) { this.outcome = GetUseCaseOfRes(example).getRes().outcome
        .toString() }
}