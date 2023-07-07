package com.banan.movietickets

import HomeScreenFile
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.banan.movietickets.detailsScreen.DetailsScreen
import com.banan.movietickets.ui.theme.MovieTicketsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            HomeScreenFile()
            DetailsScreen()
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier.clip(shape = RoundedCornerShape(5.dp))) {
    Card(shape = RoundedCornerShape(16.dp)) {

    }
    Text(
        text = "Hello $name!",
        modifier = modifier,
        color = MaterialTheme.colorScheme.error

    )
}

@Preview(showSystemUi = true)
@Composable
fun GreetingPreview() {
    MovieTicketsTheme {
        Greeting("Android")
    }
}