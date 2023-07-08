package com.banan.movietickets.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.banan.movietickets.ui.theme.border
import com.banan.movietickets.ui.theme.orangeColor
@Preview
@Composable
fun previewChips() {
   // com.banan.movietickets.composables.ChipWeekWithDay("Hello its me ", onClick = {}, isSelected = false)
    ChipTime("10:50",onClick = {}, isSelected = false)
}
@Composable
fun ChipWeekWithDay(text: String, isSelected: Boolean, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(54.dp)
            .clip(RoundedCornerShape(16.dp))
            .border(
                width = if (isSelected) 0.dp else 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(16.dp)
            )
            .background(if (isSelected) Color.Gray else Color.Transparent)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = if (isSelected) Color.White else Color.Black,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
        )
    }
}

@Composable
fun ChipTime(text: String, isSelected: Boolean, onClick: () -> Unit) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        border = if (isSelected) null else BorderStroke(1.dp, Color.LightGray),
        color = if (isSelected) Color.Gray else Color.Transparent,
        modifier = Modifier
            .padding(horizontal = 4.dp)
            .clickable(onClick = onClick)
    ) {
        Text(
            text = text,
            color = if (isSelected) Color.White else Color.Black,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
        )
    }
}

@Composable
fun Chips(
    text: String,
    fontSize: Int = 12,
    selectedChipColor: Color = orangeColor,
    selectedTextColor: Color = Color.White,
    unselectedChipColor: Color = Color.Transparent,
    unselectedTextColor: Color = orangeColor,
    isSelected: Boolean = false,
    onClick: () -> Unit,
) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        border = if (isSelected) null else BorderStroke(1.dp, border),
        color = if (isSelected) selectedChipColor else unselectedChipColor,
        modifier = Modifier
            .padding(horizontal = 4.dp)
            .clickable(onClick = onClick)
    ) {
        Title(
            text = text,
            color = if (isSelected) selectedTextColor else unselectedTextColor,
            fontSize = fontSize,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
    }
}

