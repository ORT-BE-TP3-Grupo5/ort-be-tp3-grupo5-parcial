package com.example.ortbetp3grupo5parcial.screens.favorites



import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val favoritesRoute = "favourite"

fun NavGraphBuilder.favoritesScreen(navController: NavController) {
    composable(route = favoritesRoute) {
        FavoritesScreen(navController)
    }
}