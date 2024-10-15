package com.example.ortbetp3grupo5parcial.screens.productDetail

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable


const val productDetailRoute = "productDetail"

fun NavGraphBuilder.productDetailScreen(navController: NavController) {
    composable(route = productDetailRoute) {
        ProductDetailScreen(navController)
    }
}