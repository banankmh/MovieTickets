import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.banan.movietickets.R
import com.banan.movietickets.ui.theme.border
import com.banan.movietickets.ui.theme.buttonColor
import com.banan.movietickets.ui.theme.textColor

@Preview(showSystemUi = true)
@Composable
fun HomeScreenFile() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(Modifier.padding(top = 48.dp)) {
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(buttonColor)
            ) {
                Text(text = stringResource(R.string.now_showing), color = textColor)
            }

            Spacer(modifier = Modifier.padding(horizontal = 8.dp))

            Button(
                onClick = { /*TODO*/ },
                border = BorderStroke(1.dp, border),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = border)
            ) {
                Text(text = stringResource(R.string.coming_soon), color = buttonColor)
            }
        }

        Spacer(modifier = Modifier.padding(top = 24.dp))

        Image(
            painter = painterResource(R.drawable.image_1),
            contentDescription = "movie image",
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.padding(top = 24.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(R.drawable.clock),
                contentDescription = "Time of tv"
            )

            Spacer(modifier = Modifier.padding(horizontal = 4.dp))

            Text(text = "2h 23m", fontSize = 12.sp)
        }

        Spacer(modifier = Modifier.padding(top = 24.dp))

        Text(
            text = stringResource(R.string.fantastic_beasts_the_secrets_of_dumbledore),
            fontSize = 24.sp,
            textAlign = TextAlign.Justify
        )

        Row(Modifier.padding(top = 24.dp)) {

            Button(
                onClick = { /*TODO*/ },
                border = BorderStroke(1.dp, border),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = border)
            ) {
                Text(text = stringResource(R.string.fantasy), color = buttonColor)
            }

            Spacer(modifier = Modifier.padding(horizontal = 4.dp))

            Button(
                onClick = { /*TODO*/ },
                border = BorderStroke(1.dp, border),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = border)
            ) {
                Text(text = stringResource(R.string.adventure), color = buttonColor)
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        BottomNavigation()
    }
}




