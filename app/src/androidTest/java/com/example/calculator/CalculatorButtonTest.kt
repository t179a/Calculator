package com.example.calculator

import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.unit.dp
import com.example.calculator.ui.components.CalculatorButton
import org.junit.Rule
import org.junit.Test

class CalculatorButtonTest {
    @get: Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculatorDisplayTest() {
        composeTestRule.setContent {
            CalculatorButton(buttonLabel = "AC", modifier = Modifier.size(70.dp))
        }

        composeTestRule.onNodeWithText("AC").assertExists()

    }
}