package com.example.calculator.ui

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculator.ArithmeticOperation
import com.example.calculator.CalculatorViewModel
import com.example.calculator.R
import com.example.calculator.ui.components.CalculatorButton
import com.example.calculator.ui.components.CalculatorDisplay

@Composable
fun CalculatorScreen(
    viewModel: CalculatorViewModel,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceEvenly) {
        val uiState = viewModel.calculatorUiState.collectAsState()
        CalculatorDisplay(
            currentDisplayedNumber = uiState.value.currentDisplayedNumber,
            modifier = Modifier.weight(1f)
        )
        Column(
            modifier = Modifier
                .weight(weight = 2f)
                .fillMaxWidth()
                .padding(12.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CalculatorButton(buttonLabel = stringResource(id = R.string.calculator_button_seven),
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { viewModel.onInputNumber("7") }
                )
                CalculatorButton(buttonLabel = stringResource(id = R.string.calculator_button_eight),
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { viewModel.onInputNumber("8") }

                )
                CalculatorButton(buttonLabel = stringResource(id = R.string.calculator_button_nine),
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { viewModel.onInputNumber("9") }

                )
                CalculatorButton(buttonLabel = stringResource(id = R.string.calculator_button_ac),
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { viewModel.onAllClear() }

                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CalculatorButton(buttonLabel = stringResource(id = R.string.calculator_button_four),
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { viewModel.onInputNumber("4") }

                )
                CalculatorButton(buttonLabel = stringResource(id = R.string.calculator_button_five),
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { viewModel.onInputNumber("5") }

                )
                CalculatorButton(buttonLabel = stringResource(id = R.string.calculator_button_six),
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { viewModel.onInputNumber("6") }

                )
                CalculatorButton(buttonLabel = stringResource(id = R.string.calculator_button_times),
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { viewModel.onInputOperator(ArithmeticOperation.TIMES) }
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CalculatorButton(buttonLabel = stringResource(id = R.string.calculator_button_one),
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { viewModel.onInputNumber("1") }

                )
                CalculatorButton(buttonLabel = stringResource(id = R.string.calculator_button_two),
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { viewModel.onInputNumber("2") }

                )
                CalculatorButton(buttonLabel = stringResource(id = R.string.calculator_button_three),
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { viewModel.onInputNumber("3") }

                )
                CalculatorButton(buttonLabel = stringResource(id = R.string.calculator_button_plus),
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { viewModel.onInputOperator(ArithmeticOperation.PLUS) }


                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CalculatorButton(buttonLabel = stringResource(id = R.string.calculator_button_zero),
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { viewModel.onInputZero() }

                )
                CalculatorButton(buttonLabel = stringResource(id = R.string.calculator_button_divided),
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { viewModel.onInputOperator(ArithmeticOperation.DIVIDED) }


                )
                CalculatorButton(buttonLabel = stringResource(id = R.string.calculator_button_minus),
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { viewModel.onInputOperator(ArithmeticOperation.MINUS) }

                )
                CalculatorButton(buttonLabel = stringResource(id = R.string.calculator_button_equal),
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { viewModel.onCalculate() }
                )
            }
        }
    }
}


@Preview(widthDp = 360, heightDp = 640)
@Composable
private fun CalculatorScreenPreview() {
    CalculatorScreen(viewModel = CalculatorViewModel())
}