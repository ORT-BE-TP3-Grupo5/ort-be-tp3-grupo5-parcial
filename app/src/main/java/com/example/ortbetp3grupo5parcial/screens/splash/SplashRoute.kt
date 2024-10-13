package com.example.ortbetp3grupo5parcial.screens.splash

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val splashRoute = "splash"

fun NavGraphBuilder.splashScreen(navController: NavController) {
    composable(route = splashRoute) {
        SplashScreenInit(navController)
    }
}
