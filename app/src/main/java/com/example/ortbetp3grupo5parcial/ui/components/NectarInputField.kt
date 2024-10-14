package com.example.ortbetp3grupo5parcial.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ortbetp3grupo5parcial.R

@Composable
fun NectarInputField(
    value: String,
    onValueChange: (String) -> Unit,
    labelType: String,
    isPasswordField: Boolean = false,
    modifier: Modifier = Modifier
) {

    var passwordVisible by remember { mutableStateOf(false) }

    val poppinsMedium = FontFamily(
        Font(R.font.poppins_medium, FontWeight.Medium)
    )

    val isEmailField = labelType == "Email"
    val isEmailValid = isEmailField && value.contains("@") && value.contains(".")

    Column(modifier = modifier) {
        InputLabel(labelType = labelType, fontFamily = poppinsMedium)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = if (isPasswordField) KeyboardType.Password else KeyboardType.Text
                ),
                visualTransformation = if (isPasswordField && !passwordVisible) PasswordVisualTransformation() else VisualTransformation.None,
                textStyle = LocalTextStyle.current.copy(
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontFamily = poppinsMedium,
                    fontWeight = FontWeight.Medium
                ),
                decorationBox = { innerTextField ->
                    Column {
                        innerTextField()
                        HorizontalDivider(color = Color.LightGray, thickness = 1.dp)
                    }
                },
                modifier = Modifier
                    .weight(1f)
            )

            ShowIcon(
                isEmailValid = isEmailValid,
                isPasswordField = isPasswordField,
                passwordVisible = passwordVisible
            ) {
                passwordVisible = it
            }
        }
    }
}

@Composable
fun InputLabel(labelType: String, fontFamily: FontFamily) {
    Text(
        text = labelType,
        color = Color.Gray,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        modifier = Modifier.padding(start = 8.dp, bottom = 4.dp)
    )
}

@Composable
fun ShowIcon(
    isEmailValid: Boolean,
    isPasswordField: Boolean,
    passwordVisible: Boolean,
    onVisibilityChange: (Boolean) -> Unit
) {
    if (isEmailValid) {
        Icon(
            painter = painterResource(id = R.drawable.is_email),
            contentDescription = "Email válido",
            tint = Color(0xFF34A853),
            modifier = Modifier
                .size(width = 30.dp, height = 30.dp)
                .padding(end = 8.dp)
        )
    } else if (isPasswordField) {
        val icon = if (passwordVisible) {
            painterResource(id = R.drawable.ojo_abierto)
        } else {
            painterResource(id = R.drawable.ojo_cerrado)
        }

        IconButton(onClick = {
            onVisibilityChange(!passwordVisible)
        }) {
            Icon(
                painter = icon,
                contentDescription = if (passwordVisible) "Ocultar contraseña" else "Mostrar contraseña",
                tint = Color.Unspecified,
                modifier = Modifier
                    .size(width = 33.dp, height = 33.dp)
                    .padding(end = 8.dp)
            )
        }
    }
}

