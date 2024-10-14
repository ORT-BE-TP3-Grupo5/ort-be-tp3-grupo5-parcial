package com.example.ortbetp3grupo5parcial.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign

@Composable
fun CustomTextPair(
    firstText: String,
    secondText: String,
    modifier: Modifier = Modifier,
    firstTextColor: Color = Color(0xFF181725),
    secondTextColor: Color = Color(0xFF7C7C7C),
    firstTextSize: Float = 26f,
    secondTextSize: Float = 16f
) {
    val semiBoldFont = FontFamily(Font(com.example.ortbetp3grupo5parcial.R.font.poppins_semibold))
    val poppinsMediumFont = FontFamily(Font(com.example.ortbetp3grupo5parcial.R.font.poppins_medium))

    Column(
        modifier = modifier
    ) {
        Text(
            text = firstText,
            fontSize = firstTextSize.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = semiBoldFont,
            color = firstTextColor,
            textAlign = TextAlign.Left,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = secondText,
            fontSize = secondTextSize.sp,
            fontFamily = poppinsMediumFont,
            color = secondTextColor,
            textAlign = TextAlign.Left,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}
