package com.example.calculator

data class CalculatorUiState(
    val inputFirstNumber: String = "",
    val inputLastNumber: String = "",
    val arithmeticOperation: ArithmeticOperation = ArithmeticOperation.NONE,
    val calculationResult: String = "",
    val currentDisplayedNumber: String = inputFirstNumber
)


