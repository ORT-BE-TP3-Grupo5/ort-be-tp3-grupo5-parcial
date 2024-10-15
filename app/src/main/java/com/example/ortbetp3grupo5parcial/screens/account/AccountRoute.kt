package com.example.ortbetp3grupo5parcial.screens.account

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val accountRoute = "account"

fun NavGraphBuilder.accountRouteScreen(navController: NavController) {
    composable(route = accountRoute) {
        AccountScreen(navController)
    }
}