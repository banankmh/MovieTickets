import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.banan.movietickets.ButtonStyle
import com.banan.movietickets.R
import com.banan.movietickets.Title
import com.banan.movietickets.TitleLarge
import com.banan.movietickets.Chip
import com.banan.movietickets.homeScreen.ViewPager
import com.banan.movietickets.spacingHorizontal
import com.banan.movietickets.spacingTop
import com.banan.movietickets.ui.theme.orangeColor

@Preview(showSystemUi = true)
@Composable
fun HomeScreenFile() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(Modifier.padding(top = 48.dp)) {
            ButtonStyle(
                text = stringResource(R.string.now_showing),
                textColor = Color.White,
                borderColor = Color.Transparent,
                buttonColor = orangeColor,
                onClick = {}
            )
            spacingHorizontal(8)
            ButtonStyle(
                text = stringResource(R.string.coming_soon),
                textColor = orangeColor,
                buttonColor = Color.Transparent,
                onClick = {})
        }
        spacingTop(32)
        Box(
            modifier = Modifier
                .height(395.dp)
                .fillMaxWidth()
                .weight(1f)
        ) { ViewPager() }
        spacingTop(24)
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(R.drawable.clock),
                contentDescription = "Time of tv"
            )

            spacingHorizontal(4)

            Title(text = stringResource(R.string._2h_23m), fontSize = 12)
        }
        spacingTop(24)
        TitleLarge(text = stringResource(R.string.fantastic_beasts_the_secrets_of_dumbledore))
        Row(Modifier.padding(top = 24.dp)) {

            Chip(
                stringResource(R.string.fantasy),
                chipColor = Color.Unspecified,
                textColor = Color.Black
            )

            spacingHorizontal(4)

            Chip(
                stringResource(R.string.adventure),
                chipColor = Color.Unspecified,
                textColor = Color.Black
            )
        }
        spacingTop(40)
        BottomNavigation()
    }
}




