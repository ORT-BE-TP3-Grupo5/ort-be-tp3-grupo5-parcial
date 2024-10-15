package com.example.ortbetp3grupo5parcial.ui.components.favorites

import com.example.ortbetp3grupo5parcial.models.FavoriteItem
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import com.example.ortbetp3grupo5parcial.R


@Composable
fun FavoriteProduct(product: FavoriteItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp, horizontal = 16.dp) // Reduce el padding horizontal
            .height(100.dp), // Altura mayor para cada ítem
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Imagen del producto
        Image(
            painter = painterResource(id = product.imageRes),
            contentDescription = product.name,
            modifier = Modifier
                .size(80.dp) // Imagen más grande
                .padding(end = 16.dp) // Espaciado entre imagen y texto
        )

        // Columna con el nombre y descripción
        Column(
            modifier = Modifier.weight(1f) // Hacer que el texto ocupe el resto del espacio disponible
        ) {
            Text(
                text = product.name,
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp, // Aumentar el tamaño de la fuente
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = product.description,
                fontSize = 13.sp, // Tamaño un poco más pequeño para la descripción
                color = Color.Gray
            )
        }

        // Columna con el precio y la flecha
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = product.price,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp, // Aumentar el tamaño de la fuente para el precio
                modifier = Modifier.padding(end = 10.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.arrow), // Imagen de la flecha
                contentDescription = "Arrow",
                modifier = Modifier.size(13.dp) // Tamaño de la flecha
            )
        }
    }
}

