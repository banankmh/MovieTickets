package com.banan.movietickets.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CircleWithText(
    text: String,
    textColor: Color,
    circleColor: Color,
    modifier: Modifier = Modifier
) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier) {
        Box(
            modifier = modifier
                .size(14.dp)
                .background(circleColor, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {}
        Title(
            text = text,
            color = textColor,
            modifier = modifier.padding(start = 4.dp),
            fontSize = 14
        )
    }
}