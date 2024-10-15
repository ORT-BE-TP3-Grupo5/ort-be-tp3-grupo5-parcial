package com.example.ortbetp3grupo5parcial.screens.categories

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val categoriesRoute = "categories"

fun NavGraphBuilder.categoriesScreen(navController: NavController) {
    composable(route = categoriesRoute) {
        CategoriesScreen(navController)
    }
}