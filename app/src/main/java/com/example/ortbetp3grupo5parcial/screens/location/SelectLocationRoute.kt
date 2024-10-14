package com.example.ortbetp3grupo5parcial.screens.location

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val selectLocationRoute = "selectLocation"

fun NavGraphBuilder.selectLocationScreen(navController: NavController) {
    composable(route = selectLocationRoute) {
        SelectLocationScreen(navController)
    }
}