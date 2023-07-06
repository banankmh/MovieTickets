package com.banan.movietickets

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun TitleLarge(text: String) {
    Text(
        text = text,
        fontSize = 24.sp,
        textAlign = TextAlign.Justify,
        color = Color.Black
    )
}

@Composable
fun Title(text: String, color: Color = Color.Black, fontSize: Int) {
    Text(
        text = text,
        fontSize = fontSize.sp,
        color = color
    )
}