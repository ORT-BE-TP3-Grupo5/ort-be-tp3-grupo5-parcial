package com.example.ortbetp3grupo5parcial.screens.forgotPassword

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val forgotPasswordRoute = "forgotPassword"

fun NavGraphBuilder.forgotPasswordScreen(navController: NavController) {
    composable(route = forgotPasswordRoute) {
        ForgotPasswordScreen(navController)
    }
}
