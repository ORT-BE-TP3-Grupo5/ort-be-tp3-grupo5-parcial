package com.example.ortbetp3grupo5parcial.screens.cart

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val cartRoute = "cart"

fun NavGraphBuilder.cartScreen(navController: NavController) {
    composable(route = cartRoute) {
        CartScreen(navController)
    }
}