package com.banan.movietickets

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.banan.movietickets.ui.theme.orangeColor

@Composable
fun BookingButton(){
Button(
onClick = { },
modifier = Modifier
.height(56.dp),
colors = ButtonDefaults.buttonColors(orangeColor),

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
            text = stringResource(R.string.booking),
            color = Color.White,
            fontSize = 16
        )
    }
}
}