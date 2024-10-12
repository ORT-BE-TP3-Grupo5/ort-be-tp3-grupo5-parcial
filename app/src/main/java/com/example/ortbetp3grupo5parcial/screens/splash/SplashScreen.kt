package com.example.ortbetp3grupo5parcial.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ortbetp3grupo5parcial.R
import kotlinx.coroutines.delay

@Composable
fun SplashcreenInit(navController: NavController) {
    LaunchedEffect(Unit) {
        delay(3000L)
        navController.navigate("onboarding") {
            popUpTo(splashRoute) { inclusive = true }
        }
    }

    SplashScreenContent()
}

@Composable
fun SplashScreenContent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF34A853)), // Fondo verde
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_nectar),
            contentDescription = null,
            modifier = Modifier.size(width = 267.42.dp, height = 68.61.dp),
            contentScale = ContentScale.Fit
        )
    }
}