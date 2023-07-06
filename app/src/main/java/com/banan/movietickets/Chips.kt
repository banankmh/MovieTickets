package com.banan.movietickets.homeScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.banan.movietickets.ui.theme.border
import com.banan.movietickets.ui.theme.orangeColor


@Composable
fun Chip(text: String, chipColor: Color = orangeColor, textColor: Color = orangeColor ) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, border),
        modifier = Modifier.padding(horizontal = 4.dp),
        color = chipColor
    ) {
        Text(
            text = text,
            color = textColor,
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
        )
    }
}