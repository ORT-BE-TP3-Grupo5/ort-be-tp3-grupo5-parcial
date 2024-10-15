package com.example.ortbetp3grupo5parcial.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ortbetp3grupo5parcial.R
import com.example.ortbetp3grupo5parcial.ui.theme.Gray80

/**
 * A composable function that displays a group of buttons.
 *
 * @param submitLabel The label for the submit button.
 * @param backLabel The label for the back button.
 * @param buttonWidth The width of the buttons in dp. Default is 364.
 * @param buttonHeight The height of the buttons in dp. Default is 67.
 * @param onSubmit The callback to be invoked when the submit button is clicked.
 * @param onBack The callback to be invoked when the back button is clicked.
 */
@Composable
fun ButtonGroup(
    submitLabel: String,
    backLabel: String,
    buttonWidth: Int = 364,
    buttonHeight: Int = 67,
    onSubmit: () -> Unit = {},
    onBack: () -> Unit = {}

){
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        SubmitReusableButton(
            onClick = onSubmit,
            buttonText = submitLabel,
            buttonWidth= buttonWidth,
            buttonHeight = buttonHeight
        )

        TextButton(
            onClick = onBack,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .width(buttonWidth.dp)
                .height(buttonHeight.dp),

            ) {
            Text(
                text = backLabel,
                color = Gray80,
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                textAlign = TextAlign.Center
            )
        }
    }
}