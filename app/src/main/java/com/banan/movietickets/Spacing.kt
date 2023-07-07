package com.banan.movietickets

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun spacingHorizontal(spacing:Int) {
    Spacer(modifier = Modifier.padding(horizontal = spacing.dp))
}

@Composable
fun spacingTop(spacing:Int) {
    Spacer(modifier = Modifier.padding(top = spacing.dp))
}

@Composable
fun spacingBottom(spacing:Int) {
    Spacer(modifier = Modifier.padding(bottom = spacing.dp))
}



