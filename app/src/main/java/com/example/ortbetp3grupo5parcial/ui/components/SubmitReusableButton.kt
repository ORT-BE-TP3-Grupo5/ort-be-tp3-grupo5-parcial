package com.example.ortbetp3grupo5parcial.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.ortbetp3grupo5parcial.R
import com.example.ortbetp3grupo5parcial.ui.theme.Gray10
import com.example.ortbetp3grupo5parcial.ui.theme.Green40
import com.example.ortbetp3grupo5parcial.ui.theme.Green60

@Composable
fun SubmitReusableButton(
    onClick: () -> Unit,
    buttonText: String,
    buttonWidth: Int = 364,
    buttonHeight: Int = 67,
    buttonColor: Color = Green40,
    textColor: Color = Gray10,
    secondaryText: String = ""
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .width(buttonWidth.dp)
            .clip(RoundedCornerShape(19.dp))
            .height(buttonHeight.dp)
            .background(buttonColor),
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor
        )
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier
                .align(Alignment.Center),
                horizontalArrangement = Arrangement.Center) {
                Text(
                    text = buttonText,
                    color = textColor,
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    textAlign = TextAlign.Center
                )
            }
            // Texto secundario alineado a la derecha
            if (secondaryText.isNotEmpty()) {
                Row(modifier = Modifier
                    .align(Alignment.CenterEnd)) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(4.dp))
                            .background(Green60)
                            .padding(4.dp)
                            .zIndex(1f)
                    ) {
                        Text(
                            text = secondaryText,
                            color = textColor,
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_medium))
                        )
                    }
                }
            }
        }
    }
}