package com.example.ortbetp3grupo5parcial.ui.components.product

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import com.example.ortbetp3grupo5parcial.R
import com.example.ortbetp3grupo5parcial.models.Product
import com.example.ortbetp3grupo5parcial.ui.theme.Green40

@Composable
fun ProductSection(
    title: String,           // Título de la sección (Ej: "Exclusive Offer", "Best Selling")
    products: List<Product>  // Lista de productos a mostrar en la sección
) {
    Column(modifier = Modifier.padding(16.dp)) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ){
            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f).padding(start = 8.dp),
            )
            TextButton(
                onClick = { },
            ) {
                Text(
                    text = "See all",
                    fontSize = 16.sp,
                    color = Green40,
                    fontWeight = FontWeight.Medium,
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))

        // Lista horizontal para mostrar los productos
        LazyRow {
            items(products) { product ->
                ProductCard(product, modifier = Modifier.padding(end = 12.dp))
            }
        }
    }
}
