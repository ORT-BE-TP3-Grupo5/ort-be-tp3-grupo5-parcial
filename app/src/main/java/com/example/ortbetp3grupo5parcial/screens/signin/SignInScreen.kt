package com.example.ortbetp3grupo5parcial.screens.signin

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.ortbetp3grupo5parcial.R
import com.example.ortbetp3grupo5parcial.screens.forgotPassword.forgotPasswordRoute
import com.example.ortbetp3grupo5parcial.screens.home.homeRoute
import com.example.ortbetp3grupo5parcial.screens.singup.signUpRoute
import com.example.ortbetp3grupo5parcial.ui.components.CustomTextPair
import com.example.ortbetp3grupo5parcial.ui.components.NectarInputField
import com.example.ortbetp3grupo5parcial.ui.components.SubmitReusableButton
import com.example.ortbetp3grupo5parcial.ui.components.TwoTextsComponent

@Composable
fun SignInScreen(navController: NavController, loginViewModel: LoginViewModel = viewModel()) {

    val loginResult by loginViewModel.loginResult.observeAsState()
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }

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
                .offset(x = 183.08.dp, y = 77.25.dp)
        )

        CustomTextPair(
            firstText = "Sign In",
            secondText = "Enter your emails and password",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 25.01.dp, top = 233.1.dp, end = 16.dp)
        )

        NectarInputField(
            value = email,
            onValueChange = { newEmail -> email = newEmail },
            labelType = "Email",
            isPasswordField = false,
            modifier = Modifier
                .size(width = 364.12.dp, height = 78.55.dp)
                .offset(x = 24.88.dp, y = 332.1.dp)
        )

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
                .padding(end = 8.dp),
            navController = navController
        )

        TwoTextsComponent(
            firstText = "Don't have an account?",
            secondText = "Sign Up",
            modifier = Modifier
                .offset(x = 93.dp, y = 675.2.dp),
            onSecondTextClick = {
                navController.navigate(signUpRoute)
            }
        )

        Box(
            modifier = Modifier
                .offset(x = 25.dp, y = 583.2.dp)
        ) {
            SubmitReusableButton(
                buttonText = "Log In",
                onClick = {
                    loginViewModel.login(email, password)
                }
            )

            LaunchedEffect(loginResult) {
                loginResult?.let { result ->
                    when {
                        result.isSuccess -> {
                            navController.navigate(homeRoute) {
                                popUpTo(navController.graph.startDestinationId) { inclusive = true }
                            }
                        }

                        result.isFailure -> {
                            showError = true
                        }
                    }
                }
            }

        }

        if (showError) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 16.dp)
                    .align(Alignment.BottomCenter),
                contentAlignment = Alignment.BottomCenter
            ) {
                ErrorMessage(errorMessage = "Incorrect email or password")
            }
        }
    }
}


@Composable
fun ForgotPasswordText(
    modifier: Modifier = Modifier,
    navController: NavController
) {
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
        modifier = modifier
            .padding(horizontal = 8.dp)
            .clickable {
                navController.navigate(forgotPasswordRoute)
            }
    )
}


@Composable
fun ErrorMessage(modifier: Modifier = Modifier, errorMessage: String) {
    Text(
        text = errorMessage,
        color = Color.Red,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        modifier = modifier
            .padding(horizontal = 24.dp, vertical = 4.dp)
    )
}



