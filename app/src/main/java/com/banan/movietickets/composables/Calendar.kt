package com.banan.movietickets.composables


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@Composable
fun WeekChips() {
    val currentCalendar = Calendar.getInstance()
    val totalDaysOfMonth = currentCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)
    val selectedChipIndex = remember { mutableStateOf(0) }

    val chipItems = List(totalDaysOfMonth) {
        val dayOfMonth = currentCalendar.get(Calendar.DAY_OF_MONTH)
        val dayOfWeek = currentCalendar.getDisplayName(
            Calendar.DAY_OF_WEEK,
            Calendar.SHORT,
            Locale.getDefault()
        )
        val date = "$dayOfMonth\n$dayOfWeek"
        currentCalendar.add(Calendar.DAY_OF_MONTH, -1)
        date
    }

    LazyRow(
        reverseLayout = true,
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        itemsIndexed(chipItems) { index, item ->
            ChipWeekDay(
                text = item,
                isSelected = index == selectedChipIndex.value,
                onClick = { selectedChipIndex.value = index }
            )
        }
    }
}

@Composable
fun HourChips() {
    val currentCalendar = Calendar.getInstance()
    val totalHourOfDay = currentCalendar.getActualMaximum(Calendar.HOUR_OF_DAY)
    val selectedChipIndex = remember { mutableStateOf(0) }
    val chipItems = List(totalHourOfDay) { index ->
        val time = currentCalendar.apply { set(Calendar.HOUR_OF_DAY, index) }.time
        val timeString = SimpleDateFormat("hh:mm", Locale.getDefault()).format(time)
        timeString
    }

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp),
    ) {
        itemsIndexed(chipItems) { index, item ->
            ChipWithTime(
                text = item,
                isSelected = index == selectedChipIndex.value,
                onClick = { selectedChipIndex.value = index },
            )
        }
    }
}


@Composable
fun ChipWeekDay(text: String, isSelected: Boolean, onClick: () -> Unit) {
    ChipWeekWithDay(text = text, onClick = onClick, isSelected = isSelected)
}

@Composable
fun ChipWithTime(text: String, isSelected: Boolean, onClick: () -> Unit) {
    ChipTime(text = text, onClick = onClick, isSelected = isSelected)
}
