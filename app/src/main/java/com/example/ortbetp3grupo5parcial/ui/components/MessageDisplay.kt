package com.example.ortbetp3grupo5parcial.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ortbetp3grupo5parcial.ui.theme.Gray60
import com.example.ortbetp3grupo5parcial.ui.theme.Gray80


/**
 * A composable function that displays a title and a message.
 *
 * @param title The title text to display.
 * @param message The message text to display.
 */
@Composable
fun MessageDisplay(
    title: String,
    message: String
){
    Text(
        text = title,
        color = Gray80,
        fontSize = 28.sp,
        textAlign = TextAlign.Center,
        lineHeight = 34.sp
    )
    Spacer(modifier = Modifier.height(24.dp))
    Text(
        text = message,
        color = Gray60,
        fontSize = 16.sp,
        textAlign = TextAlign.Center,
        lineHeight = 21.sp
    )
}