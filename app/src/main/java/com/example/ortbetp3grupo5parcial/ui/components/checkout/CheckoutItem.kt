package com.example.ortbetp3grupo5parcial.ui.components.checkout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ortbetp3grupo5parcial.R
import com.example.ortbetp3grupo5parcial.ui.theme.Gray60
import com.example.ortbetp3grupo5parcial.ui.theme.Gray80

@Composable
fun CheckoutItem(
    label: String,
    modifier: Modifier = Modifier,
    value: String = "",
    imageResource: Int? =  null,
    imageContentDescription: String = "",
    onClick: () -> Unit,
){
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            fontSize = 18.sp,
            color = Gray60,
            fontFamily = FontFamily(Font(R.font.poppins_medium)),
            modifier = Modifier
                .weight(1f)
                .padding(start = 20.dp)
        )
        Text(
            text = value,
            fontSize = 16.sp,
            color = Gray80,
            fontFamily = FontFamily(Font(R.font.poppins_medium))
        )
        if(value != "" && imageResource != null){
            Spacer(modifier = Modifier.width(16.dp))
        }
        if (imageResource != null){
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = imageContentDescription,
                modifier = Modifier.size(24.dp)
            )
        }
        IconButton(
            onClick = onClick,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_next),
                contentDescription = "Next",
                tint = Gray80
            )
        }
    }
}