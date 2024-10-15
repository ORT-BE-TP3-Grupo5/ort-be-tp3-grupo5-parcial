package com.example.ortbetp3grupo5parcial.ui.components.cart

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ortbetp3grupo5parcial.models.CartItemData
import com.example.ortbetp3grupo5parcial.ui.theme.Gray20

@Composable
fun CartProductList(
    items: List<CartItemData>,
    modifier: Modifier = Modifier,
    onRemoveClick: (Int) -> Unit,
    onQuantityChange: (Int, Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding( horizontal = 16.dp)
    ) {
        // Lista de productos
        itemsIndexed(items) { index, item ->
            CartProductListItem(
                imageResource = item.imageResource,
                name = item.name,
                quantityInfo = item.quantityInfo,
                price = item.price,
                onRemoveClick = { onRemoveClick(index) },
                onQuantityChange = { newQuantity -> onQuantityChange(index, newQuantity) },
                modifier = modifier.padding(vertical = 24.dp)
            )
            HorizontalDivider(color = Gray20, thickness = 1.dp)
        }
    }
}