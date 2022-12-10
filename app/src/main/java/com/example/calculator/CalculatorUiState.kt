package com.example.calculator

data class CalculatorUiState(
    val inputFirstNumber: String = "",
    val inputLastNumber: String = "",
    val arithmeticOperation: CalculatorOperation = CalculatorOperation.NONE,
    val calculationResult: String = "",
    val currentDisplayedNumber: String = inputFirstNumber
)


