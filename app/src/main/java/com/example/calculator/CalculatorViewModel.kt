package com.example.calculator

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CalculatorViewModel : ViewModel() {
    private var _calculatorUiState = MutableStateFlow(CalculatorUiState())
    val calculatorUiState = _calculatorUiState.asStateFlow()
    fun onInputNumber(inputNumber: String) {
        when (_calculatorUiState.value.arithmeticOperation) {
            ArithmeticOperation.NONE -> {
                if (_calculatorUiState.value.inputFirstNumber.length > 7) {
                    return
                } else {
                    val resultNumber: String =
                        _calculatorUiState.value.inputFirstNumber + inputNumber
                    _calculatorUiState.value = _calculatorUiState.value.copy(
                        inputFirstNumber = resultNumber,
                        currentDisplayedNumber = resultNumber
                    )
                }
            }
            else -> {
                if (_calculatorUiState.value.inputLastNumber.length > 7) {
                    return
                } else {
                    val resultNumber: String =
                        _calculatorUiState.value.inputLastNumber + inputNumber
                    _calculatorUiState.value = _calculatorUiState.value.copy(
                        inputLastNumber = resultNumber,
                        currentDisplayedNumber = resultNumber
                    )
                }
            }
        }
    }

    fun onInputZero() {
        when (_calculatorUiState.value.arithmeticOperation) {
            ArithmeticOperation.NONE -> {
                if (_calculatorUiState.value.inputFirstNumber.length > 7) {
                    return
                } else if (_calculatorUiState.value.inputFirstNumber.isEmpty()) {
                    return
                } else {
                    val resultNumber: String = _calculatorUiState.value.inputFirstNumber + "0"
                    _calculatorUiState.value = _calculatorUiState.value.copy(
                        inputFirstNumber = resultNumber,
                        currentDisplayedNumber = resultNumber
                    )
                }
            }
            else -> {
                if (_calculatorUiState.value.inputLastNumber.length > 7) {
                    return
                } else if (_calculatorUiState.value.inputLastNumber.isEmpty()) {
                    return
                } else {
                    val resultNumber: String = _calculatorUiState.value.inputLastNumber + "0"
                    _calculatorUiState.value = _calculatorUiState.value.copy(
                        inputLastNumber = resultNumber,
                        currentDisplayedNumber = resultNumber
                    )
                }
            }
        }
    }

    fun onInputOperator(operator: ArithmeticOperation) {
        if (_calculatorUiState.value.inputFirstNumber.isEmpty() || _calculatorUiState.value.inputLastNumber.isNotEmpty()) {
            return
        }
        _calculatorUiState.value = _calculatorUiState.value.copy(arithmeticOperation = operator)
    }

    fun onCalculate() {
        if (_calculatorUiState.value.inputFirstNumber.isEmpty() || _calculatorUiState.value.inputLastNumber.isEmpty()) {
            return
        }
        when (_calculatorUiState.value.arithmeticOperation) {
            ArithmeticOperation.NONE -> {
                return
            }
            ArithmeticOperation.PLUS -> {
                val calculatedResult: Long =
                    _calculatorUiState.value.inputFirstNumber.toLong() + _calculatorUiState.value.inputLastNumber.toLong()
                val newNumber: String = adjustNumberOfDigits(calculatedResult.toString())
                _calculatorUiState.value =
                    _calculatorUiState.value.copy(currentDisplayedNumber = newNumber)
            }
            ArithmeticOperation.MINUS -> {
                val calculatedResult: Long =
                    _calculatorUiState.value.inputFirstNumber.toLong() - _calculatorUiState.value.inputLastNumber.toLong()
                val newNumber: String = adjustNumberOfDigits(calculatedResult.toString())
                _calculatorUiState.value =
                    _calculatorUiState.value.copy(currentDisplayedNumber = newNumber)
            }
            ArithmeticOperation.TIMES -> {
                val calculatedResult: Long =
                    _calculatorUiState.value.inputFirstNumber.toLong() * _calculatorUiState.value.inputLastNumber.toLong()
                val newNumber: String = adjustNumberOfDigits(calculatedResult.toString())
                _calculatorUiState.value =
                    _calculatorUiState.value.copy(currentDisplayedNumber = newNumber)
            }
            ArithmeticOperation.DIVIDED -> {
                val calculatedResult: Double =
                    _calculatorUiState.value.inputFirstNumber.toDouble() / _calculatorUiState.value.inputLastNumber.toDouble()
                val newNumber: String = adjustNumberOfDigits(calculatedResult.toString())
                _calculatorUiState.value =
                    _calculatorUiState.value.copy(currentDisplayedNumber = newNumber)
            }
        }
    }

    private fun adjustNumberOfDigits(number: String): String {
        return number.take(16)
    }

    fun onAllClear() {
        _calculatorUiState.value = CalculatorUiState()
    }

}