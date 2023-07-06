package com.banan.movietickets

import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.banan.movietickets.ui.theme.border
import com.banan.movietickets.ui.theme.orangeColor

@Composable
fun ButtonStyle(
    text: String,
    buttonColor: Color = orangeColor,
    textColor: Color = Color.White,
    borderColor:Color=border,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        border = BorderStroke(1.dp, borderColor),
        colors = ButtonDefaults.buttonColors(containerColor = buttonColor)
    ) {
        Text(text = text, color = textColor, fontSize = 16.sp)
    }
}
