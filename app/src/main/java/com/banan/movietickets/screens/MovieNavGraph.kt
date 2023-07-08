package com.banan.movietickets.screens
import HomeScreenFile
import androidx.navigation.compose.composable
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.banan.movietickets.screens.detailsScreen.DetailsScreen
import com.banan.movietickets.screens.takeTicket.TakeTicket

@Composable
fun MovieNavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.HomeScreen.route) {
        composable(Screens.HomeScreen.route) { HomeScreenFile(navController) }
        composable(Screens.MovieDetailsScreen.route) { DetailsScreen(navController) }
        composable(Screens.TakeTicketScreen.route) { TakeTicket(navController) }
    }
}