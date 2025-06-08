package com.example.topacademy_android

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.topacademy_android.domain
    .GetUseCaseOfRes

class ViewModelOfCalc: ViewModel() {
    private val _example = MutableLiveData<String>()
    val getEx: LiveData<String> get() = this._example
    fun solve(example: String) { this._example.value = GetUseCaseOfRes(example).getRes()
        .outcome.toString() }
}