package com.example.ortbetp3grupo5parcial.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ortbetp3grupo5parcial.ui.theme.Gray90

@Composable
fun Header(
    text: String,
    onClickLeft: () -> Unit = { },
    onClickRight: () -> Unit = { },
    iconLeft: Int? = null,
    iconRight: Int? = null,
    contentDescriptionLeft: String = "",
    contentDescriptionRight: String = ""
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
    ){
        if(iconLeft != null) {
            Row(modifier = Modifier
                .align(Alignment.CenterStart)
            ) {
                IconButton(
                    onClick = onClickLeft,
                    modifier = Modifier.padding(horizontal = 4.dp)
                ) {
                    Icon(
                        painter = painterResource(id = iconLeft),
                        contentDescription = contentDescriptionLeft,
                    )
                }
            }
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
            .align(Alignment.Center)
        ){
            Text(
                text = text,
                fontSize = 22.sp,
                fontWeight = FontWeight.Normal,
                color = Gray90
            )
        }
        if(iconRight != null) {
            Row(
                modifier = Modifier
                .align(Alignment.CenterEnd)
            ) {
                IconButton(
                    onClick = onClickRight,
                    modifier = Modifier.padding( horizontal = 4.dp)
                ) {
                    Icon(
                        painter = painterResource(id = iconRight),
                        contentDescription = contentDescriptionRight,
                    )
                }
            }
        }
    }
}