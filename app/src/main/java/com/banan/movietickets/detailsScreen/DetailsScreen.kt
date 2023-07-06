package com.banan.movietickets.detailsScreen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Preview(showSystemUi = true)
@Composable
fun DetailsScreen(){
        ConstraintLayout(
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            val (
                close,
                time,
                movieImage,
            ) = createRefs()

    }
}