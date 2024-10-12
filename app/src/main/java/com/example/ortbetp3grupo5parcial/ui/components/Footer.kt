package com.example.ortbetp3grupo5parcial.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.ui.res.painterResource
import com.example.ortbetp3grupo5parcial.R

@Composable
fun Footer(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            .shadow(8.dp)
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        NavigationBar(
            containerColor = Color.Transparent,
            contentColor = Color.Black,
            tonalElevation = 0.dp,
        ) {
            NavigationBarItem(
                icon = { Icon(painterResource(id = R.drawable.ic_shop), contentDescription = "Shop") },
                label = { Text("Shop") },
                selected = currentRoute == "shop",
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFF4CAF50),
                    unselectedIconColor = Color.Black,
                    selectedTextColor = Color(0xFF4CAF50),
                    unselectedTextColor = Color.Black,
                    indicatorColor = Color.Transparent
                ),
                onClick = {
                    navController.navigate("shop") {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
            NavigationBarItem(
                icon = { Icon(painterResource(id = R.drawable.ic_search), contentDescription = "Explore") },
                label = { Text("Explore") },
                selected = currentRoute == "explore",
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFF4CAF50),
                    unselectedIconColor = Color.Black,
                    selectedTextColor = Color(0xFF4CAF50),
                    unselectedTextColor = Color.Black,
                    indicatorColor = Color.Transparent
                ),
                onClick = {
                    navController.navigate("explore") {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
            NavigationBarItem(
                icon = { Icon(painterResource(id = R.drawable.ic_cart), contentDescription = "Cart") },
                label = { Text("Cart") },
                selected = currentRoute == "cart",
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFF4CAF50),
                    unselectedIconColor = Color.Black,
                    selectedTextColor = Color(0xFF4CAF50),
                    unselectedTextColor = Color.Black,
                    indicatorColor = Color.Transparent
                ),
                onClick = {
                    navController.navigate("cart") {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
            NavigationBarItem(
                icon = { Icon(painterResource(id = R.drawable.ic_favourite), contentDescription = "Favourite") },
                label = { Text("Favourite") },
                selected = currentRoute == "favourite",
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFF4CAF50),
                    unselectedIconColor = Color.Black,
                    selectedTextColor = Color(0xFF4CAF50),
                    unselectedTextColor = Color.Black,
                    indicatorColor = Color.Transparent
                ),
                onClick = {
                    navController.navigate("favourite") {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
            NavigationBarItem(
                icon = { Icon(painterResource(id = R.drawable.ic_account), contentDescription = "Account") },
                label = { Text("Account") },
                selected = currentRoute == "account",
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFF4CAF50),
                    unselectedIconColor = Color.Black,
                    selectedTextColor = Color(0xFF4CAF50),
                    unselectedTextColor = Color.Black,
                    indicatorColor = Color.Transparent
                ),
                onClick = {
                    navController.navigate("account") {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
