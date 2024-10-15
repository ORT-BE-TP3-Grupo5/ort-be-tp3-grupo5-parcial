package com.example.ortbetp3grupo5parcial.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.ortbetp3grupo5parcial.R
import com.example.ortbetp3grupo5parcial.screens.cart.cartRoute
import com.example.ortbetp3grupo5parcial.screens.explore.exploreRoute
import com.example.ortbetp3grupo5parcial.screens.home.homeRoute

@Composable
fun Footer(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(92.dp)
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            .shadow(
                elevation = 15.dp,
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
            )
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
                label = {
                    Text(
                        text = "Shop",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF181725)
                    )
                },
                selected = currentRoute == "home",
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFF4CAF50),
                    unselectedIconColor = Color.Black,
                    selectedTextColor = Color(0xFF4CAF50),
                    unselectedTextColor = Color(0xFF181725),
                    indicatorColor = Color.Transparent
                ),
                onClick = {
                    navController.navigate(homeRoute) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
            NavigationBarItem(
                icon = { Icon(painterResource(id = R.drawable.ic_explore), contentDescription = "Explore") },
                label = {
                    Text(
                        text = "Explore",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF181725)
                    )
                },
                selected = currentRoute == "explore",
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFF4CAF50),
                    unselectedIconColor = Color.Black,
                    selectedTextColor = Color(0xFF4CAF50),
                    unselectedTextColor = Color(0xFF181725),
                    indicatorColor = Color.Transparent
                ),
                onClick = {
                    navController.navigate(exploreRoute) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
            NavigationBarItem(
                icon = { Icon(painterResource(id = R.drawable.ic_cart), contentDescription = "Cart") },
                label = {
                    Text(
                        text = "Cart",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF181725)
                    )
                },
                selected = currentRoute == "cart",
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFF4CAF50),
                    unselectedIconColor = Color.Black,
                    selectedTextColor = Color(0xFF4CAF50),
                    unselectedTextColor = Color(0xFF181725),
                    indicatorColor = Color.Transparent
                ),
                onClick = {
                    navController.navigate(cartRoute) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
            NavigationBarItem(
                icon = { Icon(painterResource(id = R.drawable.ic_favourite), contentDescription = "Favourite") },
                label = {
                    Text(
                        text = "Favourite",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF181725)
                    )
                },
                selected = currentRoute == "favourite",
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFF4CAF50),
                    unselectedIconColor = Color.Black,
                    selectedTextColor = Color(0xFF4CAF50),
                    unselectedTextColor = Color(0xFF181725),
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
                label = {
                    Text(
                        text = "Account",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF181725)
                    )
                },
                selected = currentRoute == "account",
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFF4CAF50),
                    unselectedIconColor = Color.Black,
                    selectedTextColor = Color(0xFF4CAF50),
                    unselectedTextColor = Color(0xFF181725),
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

