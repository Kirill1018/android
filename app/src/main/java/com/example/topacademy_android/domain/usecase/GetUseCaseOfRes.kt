package com.example.topacademy_android.domain.usecase

import com.example.topacademy_android.data
    .local.Result
import dev.franckyi.karith.api
    .result

class GetUseCaseOfRes(val solution: String) {
    fun getRes(): Result = Result(this.solution.result())
}