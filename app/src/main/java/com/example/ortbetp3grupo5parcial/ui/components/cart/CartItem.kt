package com.example.ortbetp3grupo5parcial.ui.components.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ortbetp3grupo5parcial.R
import com.example.ortbetp3grupo5parcial.ui.theme.Gray40
import java.util.Locale

@Composable
fun CartItem(
    imageResource: Int,
    name: String,
    quantityInfo: String,
    price: Double,
    onRemoveClick: () -> Unit,
    onQuantityChange: (Int) -> Unit,
    currency: String = "$",
    modifier: Modifier = Modifier
) {
    Box( modifier = modifier){
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box(  modifier = Modifier.size(76.dp).align(Alignment.CenterVertically)) {
                // Imagen del producto
                Image(
                    painter = painterResource(id = imageResource),
                    contentDescription = name,
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.FillWidth
                )
            }

            Spacer(modifier = Modifier.width(34.dp))

            Column(
                modifier = Modifier
                    .align(Alignment.Top)
            ) {
                Row( modifier = Modifier
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    //Nombre producto
                    Text(
                        text = name,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 16.sp,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .align(Alignment.Top)
                    )
                    //Boton Eliminar
                    IconButton(
                        onClick = onRemoveClick,
                        modifier = Modifier
                            .size(18.dp)
                            .align(Alignment.Top)
                    ) {
                        Icon(
                            painter = painterResource(id= R.drawable.ic_remove),
                            contentDescription = "Remove",
                            tint = Gray40
                        )
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column() {
                        Text(
                            text = quantityInfo,
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                        Spacer(modifier = Modifier
                            .height(12.dp))
                        ItemQuantity(onQuantityChange = onQuantityChange)
                    }
                    Column(
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.End
                    ){
                        Text(
                            text = "$currency " + String.format(Locale.US,"%.2f",price),
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            modifier = Modifier.align(Alignment.End)
                        )
                    }
                }
            }
        }
    }

}
