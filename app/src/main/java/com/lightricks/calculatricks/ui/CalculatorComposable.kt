// Copyright (c) 2024. Lightricks. All rights reserved.
// Created by Omri Kaplan.

package com.lightricks.calculatricks.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lightricks.calculatricks.CalculatorViewModel
import com.lightricks.calculatricks.DefaultCalculatorUseCase
import com.lightricks.calculatricks.Input
import com.lightricks.calculatricks.ui.theme.CalculatricksTheme

@Composable
fun Calculator(modifier: Modifier, calculatorViewModel: CalculatorViewModel) {
    val expression by calculatorViewModel.expression.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Text(
            text = expression,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.End
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
            modifier = modifier.fillMaxWidth()
        ) {
            items(count = Input.entries.size) { index ->
                if (index < 10) {
                    val buttonValue = (index + 1).mod(other = 10)
                    CalculatorButton(buttonValue.toString()) {
                        calculatorViewModel.onInput(Input.entries[buttonValue])
                    }
                } else {
                    CalculatorButton(text = Input.entries[index].symbol) {
                        calculatorViewModel.onInput(Input.entries[index])
                    }
                }
            }
        }
    }
}

@Composable
fun CalculatorButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        shape = MaterialTheme.shapes.large
    ) {
        Text(text = text)
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorPreview() {
    CalculatricksTheme {
        Calculator(
            modifier = Modifier.fillMaxSize(),
            calculatorViewModel = CalculatorViewModel(DefaultCalculatorUseCase())
        )
    }
}
