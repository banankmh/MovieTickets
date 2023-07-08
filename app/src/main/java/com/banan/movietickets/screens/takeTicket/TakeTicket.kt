package com.banan.movietickets.screens.takeTicket

import com.banan.movietickets.composables.BookingButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.banan.movietickets.composables.CircleWithText
import com.banan.movietickets.composables.CloseIcon
import com.banan.movietickets.composables.HourChips
import com.banan.movietickets.R
import com.banan.movietickets.composables.Title
import com.banan.movietickets.composables.TitleLarge
import com.banan.movietickets.composables.WeekChips
import com.banan.movietickets.composables.spacingTop
import com.banan.movietickets.ui.theme.onPrimaryColor
import com.banan.movietickets.ui.theme.orangeColor

@Composable
fun TakeTicket(navController: NavController) {
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black),
            contentAlignment = Alignment.Center
        ) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopStart) {
                ConstraintLayout(modifier = Modifier.fillMaxSize()) {
                    val (
                        close,
                        posterImage,
                        seats,
                        available,
                        taken,
                        selected,
                        columnDetails
                    ) = createRefs()

                    ////region close icon
                    CloseIcon(
                        modifier = Modifier
                            .constrainAs(close) {
                                top.linkTo(parent.top, margin = 24.dp)
                                start.linkTo(parent.start, margin = 16.dp)
                            },
                        onClick = {}
                    )
                    ///endregion

                    ////region poster
                    Image(
                        painter = painterResource(R.drawable.film_poster),
                        contentDescription = "poster",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .constrainAs(posterImage) {
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                                top.linkTo(close.bottom, margin = 4.dp)
                            }
                    )
                    ///endregion

                    ///region seats
                    SeatsLayout(
                        modifier=Modifier.constrainAs(seats){
                            top.linkTo(posterImage.bottom)
                            start.linkTo(parent.start)
                        }
                    )
                    ///endregion

                    ///region seats status
                    CircleWithText(
                        text = stringResource(R.string.available),
                        textColor = onPrimaryColor,
                        circleColor = onPrimaryColor,
                        modifier = Modifier
                            .constrainAs(available) {
                            bottom.linkTo(columnDetails.top, margin = 8.dp)
                            start.linkTo(parent.start, margin = 48.dp)
                        }
                            .padding(4.dp)
                    )

                    CircleWithText(
                        text = stringResource(R.string.taken),
                        textColor = Color.DarkGray,
                        circleColor = Color.DarkGray,
                        modifier = Modifier
                            .constrainAs(taken) {
                                top.linkTo(available.top)
                                start.linkTo(available.end)
                                end.linkTo(selected.start)
                        }
                            .padding(4.dp)
                    )
                    CircleWithText(
                        text = stringResource(R.string.selected),
                        textColor = orangeColor,
                        circleColor = orangeColor,
                        modifier = Modifier
                            .constrainAs(selected) {
                                bottom.linkTo(taken.bottom)
                                end.linkTo(parent.end, margin = 48.dp)

                            }
                            .padding(4.dp)
                    )
                    ///endregion

                    ///region details
                    Column(
                        modifier = Modifier
                            .height(248.dp)
                            .fillMaxSize()
                            .background(
                                shape = RoundedCornerShape(topEnd = 32.dp, topStart = 32.dp),
                                color = Color.White
                            )
                            .constrainAs(columnDetails) {
                                bottom.linkTo(parent.bottom)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }
                            .padding( vertical = 16.dp)
                    ) {
                        spacingTop(spacing = 24)
                        WeekChips()
                        spacingTop(spacing = 16)
                        HourChips()
                        Spacer(modifier = Modifier.weight(1f))
                        ConstraintLayout(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            val (pricing, title, bookingButton) = createRefs()

                            Column(
                                modifier = Modifier.constrainAs(pricing) {
                                    top.linkTo(bookingButton.top)
                                    bottom.linkTo(parent.bottom)
                                    start.linkTo(bookingButton.end)
                                    start.linkTo(parent.start, margin = 16.dp)
                                }
                            ) {
                                TitleLarge(text = stringResource(R.string._100_00))
                                spacingTop(spacing = 4)
                                Title(
                                    text = stringResource(R.string._4_tickets),
                                    color = onPrimaryColor,
                                    fontSize = 12
                                )
                            }


                            BookingButton(
                                text = stringResource(id = R.string.buy_tickets),
                                onClick = {},
                                modifier = Modifier
                                    .constrainAs(bookingButton) {
                                        bottom.linkTo(parent.bottom)
                                        end.linkTo(parent.end)
                                    }
                            )
                        }

                    }
                    ///endregion
                }

            }
        }
    }
}


