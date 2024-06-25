// Copyright (c) 2024. Lightricks. All rights reserved.
// Created by Omri Kaplan.

package com.lightricks.aicalculator

import org.mariuszgromada.math.mxparser.Expression

class AiCalculator {
    fun calculate(expression: String): String {
        return Expression(expression).calculate().toString()
    }
}