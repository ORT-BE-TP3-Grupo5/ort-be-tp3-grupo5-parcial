package com.example.ortbetp3grupo5parcial.screens.signin

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ortbetp3grupo5parcial.R
import com.example.ortbetp3grupo5parcial.ui.components.CustomTextPair
import com.example.ortbetp3grupo5parcial.ui.components.NectarInputField
import com.example.ortbetp3grupo5parcial.ui.components.SubmitReusableButton
import com.example.ortbetp3grupo5parcial.ui.components.TwoTextsComponent


@Composable
fun SignInScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.fondo_blanco_y_rosa),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(420.83.dp)
                .height(896.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.logo_nectar_naranja),
            contentDescription = "Logo Nectar Naranja",
            modifier = Modifier
                .size(width = 47.84.dp, height = 55.64.dp)
                .offset(x = 183.08.dp, y = 77.25.dp) // Uso esto para la posición de la imagen
        )

        CustomTextPair(
            firstText = "Sign In",
            secondText = "Enter your emails and password",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 25.01.dp, top = 233.1.dp, end = 16.dp)
        )
        var email by remember { mutableStateOf("") }

        NectarInputField(
            value = email,
            onValueChange = { newEmail -> email = newEmail },
            labelType = "Email",
            isPasswordField = false,
            modifier = Modifier
                .size(width = 364.12.dp, height = 78.55.dp)
                .offset(x = 24.88.dp, y = 332.1.dp)
        )

        var password by remember { mutableStateOf("") }
        NectarInputField(
            value = password,
            onValueChange = { newPassword -> password = newPassword },
            labelType = "Password",
            isPasswordField = true,
            modifier = Modifier
                .size(width = 364.12.dp, height = 78.55.dp)
                .offset(x = 24.88.dp, y = 440.65.dp)
        )

        ForgotPasswordText(
            modifier = Modifier
                .offset(x = 233.51.dp, y = 539.2.dp)
                .padding(end = 8.dp)
        )

        Box(
            modifier = Modifier
                .offset(x = 25.dp, y = 583.2.dp)
        ) {
            SubmitReusableButton(
                navController = navController,
                destination = "nextScreen",
                buttonText = "Log In"
            )
        }

        TwoTextsComponent(
            firstText = "Don't have an account?",
            secondText = "Sign Up",
            modifier = Modifier
                .offset(x = 93.dp, y = 675.2.dp)
        )

    }
}

@Composable
fun ForgotPasswordText(modifier: Modifier = Modifier) {
    val poppinsMedium = FontFamily(
        Font(R.font.poppins_medium, FontWeight.Medium)
    )

    Text(
        text = "Forgot Password?",
        fontFamily = poppinsMedium,
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        color = Color(0xFF181725),
        letterSpacing = 0.05.em,
        lineHeight = 15.13.sp,
        modifier = modifier.padding(horizontal = 8.dp)
    )
}


