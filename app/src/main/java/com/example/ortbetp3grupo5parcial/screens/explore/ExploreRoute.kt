package com.example.ortbetp3grupo5parcial.screens.explore

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val exploreRoute = "explore"

fun NavGraphBuilder.exploreScreen(navController: NavController) {
    composable(route = exploreRoute) {
        ExploreScreen(navController)
    }
}