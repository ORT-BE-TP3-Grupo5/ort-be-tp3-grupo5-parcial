package com.example.ortbetp3grupo5parcial.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ortbetp3grupo5parcial.R

@Composable
fun SubmitReusableButton(
    onClick: () -> Unit,
    buttonText: String,
    buttonWidth: Int = 364,
    buttonHeight: Int = 67,
    buttonColor: Color = Color(0xFF34A853),
    textColor: Color = Color.White
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .width(buttonWidth.dp)
            .height(buttonHeight.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor
        )
    ) {
        Text(
            text = buttonText,
            color = textColor,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.poppins_medium))
        )
    }
}