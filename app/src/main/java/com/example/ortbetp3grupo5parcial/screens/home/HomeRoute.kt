package com.example.ortbetp3grupo5parcial.screens.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable


const val homeRoute = "shop"

fun NavGraphBuilder.homeScreen(navController: NavController) {
    composable(route = homeRoute) {
        HomeScreen(navController)
    }
}