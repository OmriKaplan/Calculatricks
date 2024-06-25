// Copyright (c) 2024. Lightricks. All rights reserved.
// Created by Omri Kaplan.

package com.lightricks.calculatricks

import com.lightricks.aicalculator.AiCalculator

interface CalculatorUseCase {
    fun calculateExpression(expression: String): String
}

class DefaultCalculatorUseCase : CalculatorUseCase {

    override fun calculateExpression(expression: String): String {
        return AiCalculator().calculate(expression)
    }

}