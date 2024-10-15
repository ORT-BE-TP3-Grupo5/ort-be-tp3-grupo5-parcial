package com.example.ortbetp3grupo5parcial.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ortbetp3grupo5parcial.R
import com.example.ortbetp3grupo5parcial.ui.components.SubmitReusableButton

@Composable
fun OnboardingScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        BackgroundImage()
        Logo()
        WelcomeText()
        SecondaryText()
        OnboardingButton(navController)
    }
}

@Composable
fun OnboardingButton(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .absoluteOffset(y = 700.dp)
            .padding(bottom = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        SubmitReusableButton(
            buttonText = "Get Started",
            buttonWidth = 353,
            buttonHeight = 67,
            onClick = {
                navController.navigate("signIn")
            }
        )
    }
}

@Composable
fun SecondaryText() {
    Text(
        text = "Get your groceries in as fast as one hour",
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = FontFamily(Font(R.font.poppins_medium)),
        color = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .absoluteOffset(y = 650.dp),
        textAlign = TextAlign.Center,
        lineHeight = 18.sp
    )
}

@Composable
fun WelcomeText() {
    val poppins = FontFamily(
        Font(R.font.poppins_semibold)
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .absoluteOffset(y = 550.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome",
            fontSize = 36.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = poppins,
            color = Color.White,
            textAlign = TextAlign.Center
        )

        Text(
            text = "to our store",
            fontSize = 36.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = poppins,
            color = Color.White,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun Logo() {
    Image(
        painter = painterResource(id = R.drawable.logo_nectar_solo),
        contentDescription = null,
        modifier = Modifier
            .size(width = 48.47.dp, height = 56.36.dp)
            .absoluteOffset(x = 0.dp, y = 485.26.dp)
    )
}

@Composable
fun BackgroundImage() {
    Image(
        painter = painterResource(id = R.drawable.fondo_onboarding),
        contentDescription = null,
        modifier = Modifier
            .fillMaxSize()
            .absoluteOffset(y = (-0.35).dp),
        contentScale = ContentScale.Crop
    )
}
