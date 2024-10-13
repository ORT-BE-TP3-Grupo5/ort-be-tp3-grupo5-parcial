package com.example.ortbetp3grupo5parcial.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.ortbetp3grupo5parcial.R

@Composable
fun TwoTextsComponent(
    firstText: String,
    secondText: String,
    firstTextColor: Color = Color(0xFF181725),
    secondTextColor: Color = Color(0xFF34A853),
    modifier: Modifier = Modifier
) {
    val gilroyFont = FontFamily(Font(R.font.poppins_semibold))

    Row(modifier = modifier) {
        Text(
            text = firstText,
            fontFamily = gilroyFont,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            color = firstTextColor,
            lineHeight = 15.13.sp,
            letterSpacing = 0.05.em,
            modifier = Modifier.padding(end = 4.dp)  // Espacio entre los dos textos
        )

        // Segundo texto
        Text(
            text = secondText,
            fontFamily = gilroyFont,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            color = secondTextColor,
            lineHeight = 15.13.sp,
            letterSpacing = 0.05.em
        )
    }
}
