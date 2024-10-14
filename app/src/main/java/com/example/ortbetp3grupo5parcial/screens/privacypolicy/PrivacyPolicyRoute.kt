package com.example.ortbetp3grupo5parcial.screens.privacypolicy

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val privacyPolicyRoute = "privacyPolicy"

fun NavGraphBuilder.privacyPolicyScreen(navController: NavController) {
    composable(route = privacyPolicyRoute) {
        PrivacyPolicyScreen(navController)
    }
}