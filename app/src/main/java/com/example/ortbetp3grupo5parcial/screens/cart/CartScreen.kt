package com.example.ortbetp3grupo5parcial.screens.cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ortbetp3grupo5parcial.R
import com.example.ortbetp3grupo5parcial.models.CartItemData
import com.example.ortbetp3grupo5parcial.ui.components.Footer
import com.example.ortbetp3grupo5parcial.ui.components.Header
import com.example.ortbetp3grupo5parcial.ui.components.SubmitReusableButton
import com.example.ortbetp3grupo5parcial.ui.components.cart.CartItem
import com.example.ortbetp3grupo5parcial.ui.theme.Gray20
import java.util.Locale

@Composable
fun CartScreen(navController: NavController) {

    var items by remember { mutableStateOf(listOf(
        CartItemData(
            imageResource = R.drawable.cart_bell_pepper_red,
            name = "Bell Pepper Red",
            quantityInfo = "1kg, Price",
            quantity = 1,
            price = 4.99
        ),
        CartItemData(
            imageResource = R.drawable.cart_eggs,
            name = "Egg Chicken Red",
            quantityInfo = "4pcs, Price",
            quantity = 1,
            price = 1.99
        ),
        CartItemData(
            imageResource = R.drawable.cart_bananas,
            name = "Organic Bananas",
            quantityInfo = "12kg, Price",
            quantity = 1,
            price = 3.00
        ),
        CartItemData(
            imageResource = R.drawable.cart_ginger,
            name = "Ginger",
            quantityInfo = "250gm, Price",
            quantity = 1,
            price = 2.99
        )
    ))}

    Column(modifier = Modifier.fillMaxSize()) {
        Header(
            text= "My Cart",
            onClickLeft = { navController.popBackStack() },
            iconLeft = R.drawable.ic_leading
        )
        HorizontalDivider(color = Gray20, thickness = 1.dp, modifier = Modifier.padding(top = 24.dp))

        Row(modifier = Modifier.weight(1f)) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding( horizontal = 16.dp)
            ) {
                // Lista de productos
                itemsIndexed(items) { index, item ->
                    CartItem(
                        imageResource = item.imageResource,
                        name = item.name,
                        quantityInfo = item.quantityInfo,
                        price = item.price,
                        onRemoveClick = { items = items.toMutableList().apply { removeAt(index) }},
                        onQuantityChange = { newQuantity ->
                            items = items.toMutableList().apply {
                                this[index] = this[index].copy(quantity = newQuantity)
                            }
                        },
                        modifier = Modifier.padding(vertical = 24.dp)
                    )
                    HorizontalDivider(color = Gray20, thickness = 1.dp)
                }
            }

        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            SubmitReusableButton(
                buttonText = "Go to Checkout",
                onClick = { /* TODO */  },
                secondaryText = String.format(Locale.US, "%.2f",items.sumOf { it.price * it.quantity }.toDouble()))
        }
        Footer(navController)
    }

}
