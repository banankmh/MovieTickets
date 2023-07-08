package com.banan.movietickets.screens

sealed class Screens(val route: String) {
    object HomeScreen : Screens("HomeScreen")
    object MovieDetailsScreen : Screens("MovieDetailsScreen")
    object TakeTicketScreen : Screens("TakeTicketScreen")
}