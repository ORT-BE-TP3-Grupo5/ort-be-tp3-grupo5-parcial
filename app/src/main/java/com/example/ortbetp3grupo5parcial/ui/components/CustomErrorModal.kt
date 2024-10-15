package com.example.ortbetp3grupo5parcial.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsEndWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.zIndex
import com.example.ortbetp3grupo5parcial.R
import com.example.ortbetp3grupo5parcial.ui.theme.Gray10
import com.example.ortbetp3grupo5parcial.ui.theme.Gray80

@Composable
fun OrderFailedDialog(onDismiss: () -> Unit, onRetry: () -> Unit, onBackToHome: () -> Unit = {}) {
    Dialog(
        onDismissRequest = onDismiss,
    ) {

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(18.dp))
                .size(364.dp, 570.dp)
                .background(Color.White)
                .padding(top = 24.dp, bottom = 0.dp, start = 28.dp, end = 28.dp)
        ){
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
                ) {
                Row( modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.Top){
                    IconButton(
                        onClick = onDismiss,
                        modifier = Modifier.size(16.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_remove),
                            contentDescription = "Close",
                            tint = Gray80,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.weight(1f)
                ) {
                    // Imagen de la bolsa de compras
                    Image(
                        painter = painterResource(id = R.drawable.groceries),
                        contentDescription = "Bag of groceries",
                        modifier = Modifier.size(220.dp)
                    )

                    Spacer(modifier = Modifier.height(48.dp))
                    MessageDisplay(
                        title = "Oops! Order Failed",
                        message = "Something went terribly wrong."
                    )

                    Spacer(modifier = Modifier.height(48.dp))

                }
                Column( ){
                    ButtonGroup(
                        onSubmit = onRetry,
                        submitLabel = "Please Try Again",
                        backLabel = "Back to home",
                        onBack = onBackToHome,
                        buttonWidth = 313
                    )
                }
            }
        }
    }
}