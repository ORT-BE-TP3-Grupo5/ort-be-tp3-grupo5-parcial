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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import com.example.ortbetp3grupo5parcial.R
import com.example.ortbetp3grupo5parcial.ui.components.QuantityButton


// Modificar la clase Product para incluir un campo "details"
data class Product(val name: String, val price: String, val imageRes: Int, val details: String)

@Composable
fun ProductCard(product: Product) {
    Card(
        modifier = Modifier
            .width(150.dp)
            .height(230.dp)
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
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
                    .height(100.dp)
                    .padding(8.dp),
                contentScale = ContentScale.Fit
            )

            // Textos del producto (Nombre y detalles)
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)
            ) {
                Text(
                    text = product.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    maxLines = 1,
                    modifier = Modifier.padding(top = 2.dp)
                )
                Text(
                    text = product.unit, // Usamos la variable "details"
                    fontSize = 12.sp,
                    color = Color.Gray,
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
                    text = product.price,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )

                // Botón verde con el icono "+"
                QuantityButton(onClick = {})
            }
        }
    }
}
