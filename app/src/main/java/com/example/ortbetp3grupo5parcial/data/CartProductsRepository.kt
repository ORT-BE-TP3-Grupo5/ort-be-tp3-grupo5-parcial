package com.example.ortbetp3grupo5parcial.data

import com.example.ortbetp3grupo5parcial.R
import com.example.ortbetp3grupo5parcial.models.CartItemData

object CartProductsRepository {
    private val cartItems = listOf(CartItemData(
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
    )

    fun getCartItems(): List<CartItemData> = cartItems

}