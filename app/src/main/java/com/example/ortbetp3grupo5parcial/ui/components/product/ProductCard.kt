package com.example.ortbetp3grupo5parcial.ui.components.product

import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.ortbetp3grupo5parcial.models.Product
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.navigation.NavController
import com.example.ortbetp3grupo5parcial.R
import com.example.ortbetp3grupo5parcial.screens.productDetail.productDetailRoute
import com.example.ortbetp3grupo5parcial.ui.components.QuantityButton
import com.example.ortbetp3grupo5parcial.ui.theme.Gray20
import com.example.ortbetp3grupo5parcial.ui.theme.Gray60
import com.example.ortbetp3grupo5parcial.ui.theme.Gray80
import java.util.Locale


// Modificar la clase Product para incluir un campo "details"
data class Product(val name: String, val price: String, val imageRes: Int, val details: String)

@Composable
fun ProductCard(
    product: Product,
    modifier : Modifier = Modifier,
    onClick: () -> Unit = {},
    navController: NavController
){
    Box(
        modifier = modifier
    ){
        Card(
            modifier = Modifier
                .clip(RoundedCornerShape(18.dp))
                .width(173.dp)
                .height(248.dp)
                .border(1.dp, Gray20, RoundedCornerShape(18.dp))
                .padding(6.dp),

            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                // Imagen del producto
                Image(
                    painter = painterResource(id = product.imageRes),
                    contentDescription = product.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(108.dp)
                        .padding(8.dp),
                    contentScale = ContentScale.Fit
                )
                Spacer(modifier = Modifier.height(8.dp))
                // Textos del producto (Nombre y detalles)
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 8.dp)
                ) {
                    Text(
                        text = product.name,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        color = Gray80,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        maxLines = 1,
                        modifier = Modifier.padding(top = 2.dp)
                    )
                    Text(
                        text = product.unit, // Usamos la variable "details"
                        fontSize = 14.sp,
                        color = Gray60,
                        // Ajusta este valor para acercar el texto al nombre
                    )
                }

                // Precio y botón
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Precio a la izquierda
                    Text(
                        text = String.format(Locale.US, product.price, "%.2f"),
                        color = Gray80,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        fontSize = 18.sp
                    )

                    // Botón verde con el icono "+"
                    QuantityButton(onClick = {
                        navController.navigate(productDetailRoute)
                    })
                }
            }
        }
    }

}
