package com.example.calculator

import org.junit.Assert
import org.junit.Test

class CalculatorViewModelTest {
    private val viewModel = CalculatorViewModel()

    @Test
    fun calculatorViewModel_MaxNumberAddition() {
        repeat(8) {
            viewModel.onInputNumber("9")
        }
        viewModel.onInputOperator(ArithmeticOperation.PLUS)
        repeat(8) {
            viewModel.onInputNumber("9")
        }
        viewModel.onCalculate()
        val expected: Long = "99999999".toLong() + "99999999".toLong()
        Assert.assertEquals(
            expected,
            viewModel.calculatorUiState.value.currentDisplayedNumber.toLong()
        )
    }

    @Test
    fun calculatorViewModel_MaxNumberMultiplication() {
        viewModel.onAllClear()
        repeat(8) {
            viewModel.onInputNumber("9")
        }
        viewModel.onInputOperator(ArithmeticOperation.TIMES)
        repeat(8) {
            viewModel.onInputNumber("9")
        }
        viewModel.onCalculate()
        val expected: Long = "99999999".toLong() * "99999999".toLong()
        Assert.assertEquals(
            expected,
            viewModel.calculatorUiState.value.currentDisplayedNumber.toLong()
        )
    }
    @Test
    fun calculatorViewModel_MinNumberSubtraction() {
        viewModel.onAllClear()
        repeat(1) {
            viewModel.onInputNumber("1")
        }
        viewModel.onInputOperator(ArithmeticOperation.MINUS)
        repeat(8) {
            viewModel.onInputNumber("9")
        }
        viewModel.onCalculate()
        val expected: Long = "1".toLong() - "99999999".toLong()
        Assert.assertEquals(
            expected,
            viewModel.calculatorUiState.value.currentDisplayedNumber.toLong()
        )
    }
}