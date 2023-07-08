package com.banan.movietickets.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.banan.movietickets.R
import com.banan.movietickets.ui.theme.orangeColor

@Preview
@Composable
fun previewBookingButton() {
    BookingButton("1Buy Book",onClick = {})
}
@Composable
fun BookingButton(text:String,onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        modifier = modifier.padding(8.dp)
         ,
        colors = ButtonDefaults.buttonColors(orangeColor)
    ) {
        Row(verticalAlignment = Alignment.Bottom) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.cart),
                modifier = Modifier.size(18.dp),
                contentDescription = "book icons",
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(8.dp))
            Title(
                text = text,
                color = Color.White,
                fontSize = 16
            )
        }
    }
}
