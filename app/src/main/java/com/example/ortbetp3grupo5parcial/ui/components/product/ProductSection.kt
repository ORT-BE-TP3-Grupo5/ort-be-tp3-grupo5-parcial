package com.example.ortbetp3grupo5parcial.ui.components.product

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import com.example.ortbetp3grupo5parcial.models.Product

@Composable
fun ProductSection(
    title: String,           // Título de la sección (Ej: "Exclusive Offer", "Best Selling")
    products: List<Product>  // Lista de productos a mostrar en la sección
) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Lista horizontal para mostrar los productos
        LazyRow {
            items(products) { product ->
                ProductCard(product)
            }
        }
    }
}
