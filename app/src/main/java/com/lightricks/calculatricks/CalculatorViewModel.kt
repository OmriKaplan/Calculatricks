// Copyright (c) 2024. Lightricks. All rights reserved.
// Created by Omri Kaplan.

package com.lightricks.calculatricks

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CalculatorViewModel(private val useCase: CalculatorUseCase) : ViewModel() {
    private val _expression = MutableStateFlow("")
    val expression: StateFlow<String> = _expression

    fun onInput(input: Input) {
        when (input) {
            Input.EQUALS -> _expression.value = useCase.calculateExpression(_expression.value)
            Input.CLEAR -> _expression.value = ""
            else -> {
                _expression.value += input.symbol
            }
        }
    }
}


enum class Input(val symbol: String) {
    DIGIT_0(0.toString()),
    DIGIT_1(1.toString()),
    DIGIT_2(2.toString()),
    DIGIT_3(3.toString()),
    DIGIT_4(4.toString()),
    DIGIT_5(5.toString()),
    DIGIT_6(6.toString()),
    DIGIT_7(7.toString()),
    DIGIT_8(8.toString()),
    DIGIT_9(9.toString()),
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    EQUALS("="),
    CLEAR("C")
}