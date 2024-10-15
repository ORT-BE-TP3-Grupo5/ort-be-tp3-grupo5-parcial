package com.example.ortbetp3grupo5parcial.screens.order

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val orderReviewRoute = "orderReview"

fun NavGraphBuilder.orderReviewScreen(navController: NavController) {
    composable(route = orderReviewRoute) {
        OrderReviewScreen(navController)
    }
}