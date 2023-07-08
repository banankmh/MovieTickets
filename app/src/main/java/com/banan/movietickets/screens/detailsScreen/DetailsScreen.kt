package com.banan.movietickets.screens.detailsScreen

import com.banan.movietickets.composables.BookingButton
import com.banan.movietickets.composables.Chips
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.banan.movietickets.composables.CloseIcon
import com.banan.movietickets.composables.ColoredText
import com.banan.movietickets.R
import com.banan.movietickets.composables.Title
import com.banan.movietickets.composables.TitleLarge
import com.banan.movietickets.composables.spacingHorizontal
import com.banan.movietickets.composables.spacingTop
import com.banan.movietickets.ui.theme.TealBlur
import com.banan.movietickets.ui.theme.orangeColor

@Composable
fun DetailsScreen(navController: NavController) {

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (
            close, time, play,
            movieImage, details
        ) = createRefs()

        ///region poster image
        Image(
            painter = painterResource(id = R.drawable.movie_details),
            contentDescription = "movie image",
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(380.dp)
                .fillMaxWidth()
                .constrainAs(movieImage) {}
        )
        ///endregion

        ///region close
        CloseIcon(
            modifier = Modifier.constrainAs(close) {
                top.linkTo(parent.top, margin = 24.dp)
                start.linkTo(parent.start, margin = 16.dp)
            },
            onClick = {}
        )
        ///endregion

        ///region time
        Row(
            modifier = Modifier
                .padding(end = 16.dp)
                .clip(shape = RoundedCornerShape(16.dp))
                .background(color = TealBlur.copy(alpha = .87f))
                .constrainAs(time) {
                    end.linkTo(parent.end)
                    top.linkTo(close.top)
                    bottom.linkTo(close.bottom)
                }
        ) {
            Image(
                painter = painterResource(id = R.drawable.clock),
                contentDescription = null,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(start = 8.dp)
                    .align(Alignment.CenterVertically)
            )
            Text(
                text = "2h 23m",
                color = Color.White,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
            )
        }
        ///endregion

        ///region play button

        Box(
            modifier = Modifier
                .constrainAs(play) {
                    start.linkTo(movieImage.start)
                    end.linkTo(movieImage.end)
                    top.linkTo(movieImage.top)
                    bottom.linkTo(movieImage.bottom)
                }
                .size(56.dp)
                .background(orangeColor, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.play),
                contentDescription = "contentDescription",
                modifier = Modifier.size(48.dp / 2)
            )
        }

        ///endregion

        ///region details

        Column(
            modifier = Modifier
                .constrainAs(details) {
                    top.linkTo(movieImage.bottom, margin = (-32).dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .clip(shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                .fillMaxSize()
                .background(color = Color.White),
            horizontalAlignment = Alignment.CenterHorizontally) {

            spacingTop(spacing = 24)

            Row() {
                ColoredText(stringResource(R.string._6_8_10), stringResource(R.string.imdb), 3)
                spacingHorizontal(32)
                ColoredText(
                    stringResource(R.string._63),
                    stringResource(R.string.rotten_tomatoes),
                    3
                )
                spacingHorizontal(32)
                ColoredText(stringResource(R.string._4_10), stringResource(R.string.ign), 1)
            }

            spacingTop(spacing = 16)

            TitleLarge(stringResource(R.string.fantastic_beasts_the_secrets_of_dumbledore))

            Row(Modifier.padding(top = 8.dp)) {

                Chips(
                  text=stringResource(R.string.fantasy),
                    unselectedChipColor = Color.White,
                    unselectedTextColor = Color.Black,
                    isSelected = false,
                    onClick = {}
                )

                spacingHorizontal(4)

                Chips(
                    stringResource(R.string.adventure),
                    unselectedChipColor = Color.White,
                    unselectedTextColor = Color.Black,
                    isSelected = false,
                    onClick = {}
              )
            }

            spacingTop(spacing = 8)

            PeopleList()

            spacingTop(spacing = 16)

            Title(text = stringResource(R.string.description), fontSize = 12)

            spacingTop(spacing = 8)

            BookingButton(text=stringResource(R.string.booking),onClick = {})
        }
        ///endregion
    }
}
