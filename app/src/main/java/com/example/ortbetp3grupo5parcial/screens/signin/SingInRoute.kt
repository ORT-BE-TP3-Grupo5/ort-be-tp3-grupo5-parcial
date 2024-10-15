package com.example.ortbetp3grupo5parcial.screens.signin

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val signInRoute = "signIn"

fun NavGraphBuilder.signInScreen(navController: NavController) {
    composable(route = signInRoute) {
        SignInScreen(navController)
    }
}