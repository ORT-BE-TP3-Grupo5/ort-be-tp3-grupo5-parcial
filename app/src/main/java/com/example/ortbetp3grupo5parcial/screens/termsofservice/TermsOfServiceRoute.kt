package com.example.ortbetp3grupo5parcial.screens.termsofservice

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val termsOfServiceRoute = "termsOfService"

fun NavGraphBuilder.termsOfServiceScreen(navController: NavController) {
    composable(route = termsOfServiceRoute) {
        TermsOfServiceScreen(navController)
    }
}