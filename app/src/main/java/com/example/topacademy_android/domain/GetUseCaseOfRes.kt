package com.example.topacademy_android.domain

import com.example.topacademy_android.data
    .Result
import dev.franckyi.karith.api
    .result

class GetUseCaseOfRes(val solution: String) {
    fun getRes(): Result = Result(this.solution.result())
}