package com.banan.movietickets.screens.takeTicket

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.banan.movietickets.R
import com.banan.movietickets.composables.spacingHorizontal
import com.banan.movietickets.ui.theme.UnSelectedSeat
import com.banan.movietickets.ui.theme.orangeColor
import kotlin.random.Random

@Preview(showSystemUi = true)
@Composable
fun SeatsLayout(modifier: Modifier = Modifier) {
    val selectedSeats = remember { mutableStateListOf<Int>() }

    Row(modifier = modifier.padding(vertical = 4.dp)) {
        repeat(3) { columnIndex ->
            val paddingStart = if (columnIndex % 2 == 1) 4.dp else 16.dp
            val paddingEnd = if (columnIndex % 2 == 0) 4.dp else 16.dp
            Row(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = paddingStart, end = paddingEnd)
            ) {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                ) {
                    repeat(3) { rowIndex ->
                        val seatNumber = (columnIndex * 5) + rowIndex + 1
                        val isSelected = selectedSeats.contains(seatNumber)
                        val seatRotation = getSeatRotation(columnIndex, rowIndex)
                        Seat(seatNumber, isSelected, seatRotation) {
                            if (isSelected) {
                                selectedSeats.remove(seatNumber)
                            } else {
                                selectedSeats.add(seatNumber)
                            }
                        }
                        if (rowIndex < 4) {
                            Spacer(modifier = Modifier.height(24.dp))
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun Seat(
    seatNumber: Int,
    isSelected: Boolean,
    rotationAngle: Float,
    onSeatSelected: (Int) -> Unit
) {
    val randomGraySeats = remember { mutableStateListOf<Int>() }
    val seatColor = getSeatColor(isSelected, seatNumber, randomGraySeats)
    val seatBorderColor = getSeatBorderColor(isSelected)

    Box(
        modifier = Modifier
            .size(64.dp)
            .rotate(rotationAngle)
            .clickable { onSeatSelected(seatNumber) }
    ) {
        SeatBox(
            seatColor = seatBorderColor,
            contentColor = seatColor,
            isSelected = isSelected
        )
    }
    LaunchedEffect(Unit) {
        repeat(10) {
            val randomSeat = Random.nextInt(1, 31)
            randomGraySeats.add(randomSeat)
        }
    }
}
@Composable
private fun getSeatColor(
    isSelected: Boolean,
    seatNumber: Int,
    randomGraySeats: List<Int>
): Color {
    return when {
        isSelected -> orangeColor
        seatNumber in randomGraySeats -> Color.Gray
        else -> Color.White
    }
}

@Composable
private fun getSeatBorderColor(isSelected: Boolean)= if (isSelected) orangeColor else UnSelectedSeat


@Composable
private fun SeatBox(
    seatColor: Color,
    contentColor: Color,
    isSelected: Boolean
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp)
    ) {
        Row(Modifier.fillMaxSize()) {
            IconSeat(modifier = Modifier.weight(1f), tint = contentColor)
            spacingHorizontal(4)
            IconSeat(modifier = Modifier.weight(1f), tint = contentColor)
        }
    }
}


@Composable
private fun IconSeat(modifier: Modifier = Modifier, tint: Color = Color(0xCC787878)) {
    Box(modifier = modifier) {
        Icon(
            tint = tint,
            modifier = Modifier.fillMaxSize(),
            contentDescription = stringResource(R.string.seat),
            painter = painterResource(id = R.drawable.ic_seat),
        )
    }
}


fun getSeatRotation(columnIndex: Int, rowIndex: Int): Float {
    return when {
        columnIndex == 0 && rowIndex in 0..5 -> 11.5f
        columnIndex == 2 && rowIndex in 0..5 -> -11.5f
        else -> 0f
    }
}


