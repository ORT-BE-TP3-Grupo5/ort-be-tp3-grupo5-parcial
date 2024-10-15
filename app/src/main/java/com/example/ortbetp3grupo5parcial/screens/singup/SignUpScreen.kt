package com.example.ortbetp3grupo5parcial.screens.singup

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ortbetp3grupo5parcial.R
import com.example.ortbetp3grupo5parcial.screens.location.selectLocationRoute
import com.example.ortbetp3grupo5parcial.screens.privacypolicy.privacyPolicyRoute
import com.example.ortbetp3grupo5parcial.screens.signin.signInRoute
import com.example.ortbetp3grupo5parcial.screens.termsofservice.termsOfServiceRoute
import com.example.ortbetp3grupo5parcial.ui.components.CustomTextPair
import com.example.ortbetp3grupo5parcial.ui.components.NectarInputField
import com.example.ortbetp3grupo5parcial.ui.components.SubmitReusableButton
import com.example.ortbetp3grupo5parcial.ui.components.TwoTextsComponent

@Composable
fun SignUpScreen(navController: NavController) {

    var email by remember { mutableStateOf("") }
    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

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
            firstText = "Sign Up",
            secondText = "Enter your credentials to continue",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.01.dp, top = 233.1.dp, end = 16.dp)
        )

        NectarInputField(
            value = userName,
            onValueChange = { newUserName -> userName = newUserName },
            labelType = "UserName",
            isPasswordField = false,
            modifier = Modifier
                .size(width = 364.12.dp, height = 78.55.dp)
                .offset(x = 24.88.dp, y = 332.1.dp)
        )

        NectarInputField(
            value = email,
            onValueChange = { newEmail -> email = newEmail },
            labelType = "Email",
            isPasswordField = false,
            modifier = Modifier
                .size(width = 364.12.dp, height = 78.55.dp)
                .offset(x = 24.88.dp, y = 440.65.dp)
        )

        NectarInputField(
            value = password,
            onValueChange = { newPassword -> password = newPassword },
            labelType = "Password",
            isPasswordField = true,
            modifier = Modifier
                .size(width = 364.12.dp, height = 78.55.dp)
                .offset(x = 24.88.dp, y = 549.2.dp)
        )

        MixedColorTextComponent(navController)

        Box(
            modifier = Modifier
                .offset(x = 25.dp, y = 712.75.dp)
        ) {
            SubmitReusableButton(
                buttonText = "Sing Up",
                onClick = {
                    navController.navigate(selectLocationRoute)
                }
            )

        }

        TwoTextsComponent(
            firstText = "Already have an account?",
            secondText = "Sign In",
            modifier = Modifier
                .offset(x = 86.49.dp, y = 787.75.dp),
            onSecondTextClick = {
                navController.navigate(signInRoute)
            }
        )
    }
}


@Composable
fun MixedColorTextComponent(navController: NavController) {
    val poppinsFont = FontFamily(Font(R.font.poppins_medium))

    val annotatedText = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color(0xFF181725), fontFamily = poppinsFont, fontSize = 14.sp, fontWeight = FontWeight.Medium)) {
            append("By continuing you agree to our ")
        }

        pushStringAnnotation(tag = "terms", annotation = "terms")
        withStyle(style = SpanStyle(color = Color(0xFF34A853), fontFamily = poppinsFont, fontSize = 14.sp, fontWeight = FontWeight.Medium)) {
            append("Terms of Service")
        }
        pop()

        append("\n")

        withStyle(style = SpanStyle(color = Color(0xFF181725), fontFamily = poppinsFont, fontSize = 14.sp, fontWeight = FontWeight.Medium)) {
            append(" and ")
        }

        pushStringAnnotation(tag = "privacy", annotation = "privacy")
        withStyle(style = SpanStyle(color = Color(0xFF34A853), fontFamily = poppinsFont, fontSize = 14.sp, fontWeight = FontWeight.Medium)) {
            append("Privacy Policy.")
        }
        pop()
    }

    ClickableText(
        text = annotatedText,
        modifier = Modifier.offset(x = 24.88.dp, y = 647.75.dp),
        style = LocalTextStyle.current.copy(textAlign = TextAlign.Left),
        onClick = { offset ->
            annotatedText.getStringAnnotations(tag = "terms", start = offset, end = offset)
                .firstOrNull()?.let {
                    navController.navigate(termsOfServiceRoute)
                }

            annotatedText.getStringAnnotations(tag = "privacy", start = offset, end = offset)
                .firstOrNull()?.let {
                    navController.navigate(privacyPolicyRoute)
                }
        }
    )
}
