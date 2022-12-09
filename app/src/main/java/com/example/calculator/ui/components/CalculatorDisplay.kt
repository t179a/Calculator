package com.example.calculator.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorDisplay(currentDisplayedNumber: String, modifier: Modifier = Modifier) {
    Box(contentAlignment = Alignment.Center, modifier = modifier) {
        Text(
            text = currentDisplayedNumber,
            fontSize = 32.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            textAlign = TextAlign.End,
            maxLines = 1
        )
    }
}

@Preview(widthDp = 320, heightDp = 640)
@Composable
private fun CalculatorDisplayPreview() {
    CalculatorDisplay(
        //16桁
        currentDisplayedNumber = "1000000000000000",
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
    )
}