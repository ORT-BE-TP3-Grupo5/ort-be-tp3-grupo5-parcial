package com.example.ortbetp3grupo5parcial.screens.singup

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val signUpRoute = "signUp"

fun NavGraphBuilder.signUpScreen(navController: NavController) {
    composable(route = signUpRoute) {
        com.example.ortbetp3grupo5parcial.screens.singup.SignUpScreen(navController)
    }
}