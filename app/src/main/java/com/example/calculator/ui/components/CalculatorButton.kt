package com.example.calculator.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorButton(
    buttonLabel: String,
    onClick: () -> Unit = {},
    colors: ButtonColors = ButtonDefaults.filledTonalButtonColors(),
    modifier: Modifier
) {
    TextButton(
        onClick = onClick,
        modifier = modifier,
        colors = colors,
        shape = CircleShape,
    ) {
        Text(text = buttonLabel, fontSize = 32.sp, fontStyle = FontStyle.Normal)
    }
}


@Preview
@Composable
private fun PreviewCalculatorButton() {
    CalculatorButton(
        buttonLabel = "AC",
        onClick = { },
        colors = ButtonDefaults.filledTonalButtonColors(),
        modifier = Modifier.size(70.dp)
    )
}