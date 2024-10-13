package com.example.ortbetp3grupo5parcial.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ortbetp3grupo5parcial.R
import com.example.ortbetp3grupo5parcial.ui.theme.Gray20
import com.example.ortbetp3grupo5parcial.ui.theme.Green40

@Composable
fun QuantityButton(
    onClick: () -> Unit,
    invertedColors: Boolean = false,
   iconResource: Int = R.drawable.ic_quantity_add
) {
    var backgroundColor: Color
    var iconColor: Color
    var borderColor: Color

    if (invertedColors) {
        backgroundColor = Color.White
        iconColor = Green40
        borderColor = Gray20
    }else{
        backgroundColor = Green40
        iconColor = Color.White
        borderColor = Color.White
    }

    IconButton(
        onClick = onClick,
        modifier = Modifier
            .size(48.dp)
            .clip(RoundedCornerShape(17.dp))
            .border(1.dp, borderColor, shape = RoundedCornerShape(17.dp))
            .background(backgroundColor)
    ) {
        Icon(
            painter = painterResource(id = iconResource),
            contentDescription = "Increment",
            tint = iconColor
        )
    }
}

