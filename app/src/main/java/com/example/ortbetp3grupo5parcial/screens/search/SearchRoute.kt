package com.example.ortbetp3grupo5parcial.screens.search

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val searchRoute = "search"

fun NavGraphBuilder.searchScreen(navController: NavController) {
    composable(route = searchRoute) {
        SearchScreen(navController)
    }
}