package com.example.ortbetp3grupo5parcial.screens.onboarding

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val onboardingRoute = "onboarding"

fun NavGraphBuilder.onboardingScreen(navController: NavController) {
    composable(route = onboardingRoute) {
        OnboardingScreen(navController)
    }
}