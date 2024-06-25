// Copyright (c) 2024. Lightricks. All rights reserved.
// Created by Omri Kaplan.

package com.lightricks.calculatricks

interface CalculatorUseCase {
    fun calculateExpression(expression: String): String
}

class DefaultCalculatorUseCase : CalculatorUseCase {

    override fun calculateExpression(expression: String): String {
        val parts = expression.split(Regex("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)"))
        var result = parts[0].toDouble()

        for (i in 1 until parts.size step 2) {
            when (parts[i]) {
                "+" -> result += parts[i + 1].toDouble()
                "-" -> result -= parts[i + 1].toDouble()
                "*" -> result *= parts[i + 1].toDouble()
                "/" -> result /= parts[i + 1].toDouble()
            }
        }

        return result.toString()
    }

}