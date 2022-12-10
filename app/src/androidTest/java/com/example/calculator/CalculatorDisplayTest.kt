package com.example.calculator

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.example.calculator.ui.components.CalculatorDisplay
import org.junit.Rule
import org.junit.Test

class CalculatorDisplayTest {
    @get: Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculatorDisplayTest() {
        composeTestRule.setContent {
            CalculatorDisplay(currentDisplayedNumber = "12345")
        }

        composeTestRule.onNodeWithText("12345").assertIsDisplayed()
    }
}