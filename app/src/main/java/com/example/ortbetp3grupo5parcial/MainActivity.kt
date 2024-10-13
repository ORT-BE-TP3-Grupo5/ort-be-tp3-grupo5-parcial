package com.example.ortbetp3grupo5parcial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.ortbetp3grupo5parcial.screens.onboarding.onboardingScreen
import com.example.ortbetp3grupo5parcial.screens.signin.signInScreen
import com.example.ortbetp3grupo5parcial.screens.splash.splashRoute
import com.example.ortbetp3grupo5parcial.screens.splash.splashScreen
import com.example.ortbetp3grupo5parcial.ui.theme.OrtBeTp3Grupo5ParcialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OrtBeTp3Grupo5ParcialTheme {
                val navController: NavHostController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = splashRoute // Inicia en la pantalla Splash
                ) {
                    splashScreen(navController)    // Ruta Splash
                    onboardingScreen(navController) // Ruta Onboarding
                    signInScreen(navController)    // Ruta SignIn
                }
            }
        }
    }
}