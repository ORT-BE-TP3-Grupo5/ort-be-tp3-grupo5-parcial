package com.example.ortbetp3grupo5parcial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.ortbetp3grupo5parcial.screens.account.accountRouteScreen
import com.example.ortbetp3grupo5parcial.screens.cart.cartScreen
import com.example.ortbetp3grupo5parcial.screens.forgotPassword.forgotPasswordScreen
import com.example.ortbetp3grupo5parcial.screens.location.selectLocationScreen
import com.example.ortbetp3grupo5parcial.screens.onboarding.onboardingScreen
import com.example.ortbetp3grupo5parcial.screens.privacypolicy.privacyPolicyScreen
import com.example.ortbetp3grupo5parcial.screens.signin.signInScreen
import com.example.ortbetp3grupo5parcial.screens.singup.signUpScreen
import com.example.ortbetp3grupo5parcial.screens.splash.splashRoute
import com.example.ortbetp3grupo5parcial.screens.splash.splashScreen
import com.example.ortbetp3grupo5parcial.screens.termsofservice.termsOfServiceScreen
import com.example.ortbetp3grupo5parcial.ui.theme.OrtBeTp3Grupo5ParcialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OrtBeTp3Grupo5ParcialTheme {
                val navController: NavHostController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = splashRoute
                ) {
                    splashScreen(navController)
                    onboardingScreen(navController)
                    signInScreen(navController)
                    forgotPasswordScreen(navController)
                    signUpScreen(navController)
                    cartScreen(navController)
                    termsOfServiceScreen(navController)
                    privacyPolicyScreen(navController)
                    selectLocationScreen(navController)
                    accountRouteScreen(navController)
                }
            }
        }
    }
}