package com.banan.movietickets.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun TitleLarge(text: String , modifier: Modifier=Modifier) {
    Text(
        text = text,
        fontSize = 24.sp,
        textAlign = TextAlign.Justify,
        color = Color.Black
    )
}

@Composable
fun Title(text: String, color: Color = Color.Black, fontSize: Int,modifier:Modifier=Modifier) {
    Text(
        text = text,
        fontSize = fontSize.sp,
        color = color,
        textAlign = TextAlign.Center
    )
}

@Composable
fun ColoredText(text: String, text2: String, charsInBlack: Int) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.wrapContentSize()
    ) {
        Row {
            Text(
                text = text.substring(0, charsInBlack),
                color = Color.Black,
                textAlign = TextAlign.Center,
                fontSize=16.sp,
                modifier = Modifier.wrapContentSize()
            )
            Text(
                text = text.substring(charsInBlack),
                color = Color.LightGray,
                textAlign = TextAlign.Center,
                fontSize=16.sp,
                modifier = Modifier.wrapContentSize()
            )
        }
        Text(
            text = text2,
            color = Color.LightGray,
            textAlign = TextAlign.Center,
            fontSize=16.sp,
            modifier = Modifier.wrapContentSize()
        )
    }
}