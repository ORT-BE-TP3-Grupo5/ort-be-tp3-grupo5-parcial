package com.example.ortbetp3grupo5parcial.data

import com.example.ortbetp3grupo5parcial.R
import com.example.ortbetp3grupo5parcial.models.Product

class BeverageRepository {
    fun getAllData(): List<Product> {
        return listOf(
            Product(
                name = "Diet Coke",
                unit = "355ml, Price",
                price = "$1.99",
                imageRes = R.drawable.dietcoke
            ),
            Product(
                name = "Sprite Can",
                unit = "325ml, Price",
                price = "$1.50",
                imageRes = R.drawable.sprite
            ),
            Product(
                name = "Apple & Grape Juice",
                unit = "2L, Price",
                price = "$15.99",
                imageRes = R.drawable.applejuice
            ),
            Product(
                name = "Orenge Juice",
                unit = "2L, Price",
                price = "$15.99",
                imageRes =  R.drawable.orangejuice
            ),
            Product(
                name = "Coca Cola Can",
                unit = "325ml, Price",
                price = "$4.99",
                imageRes = R.drawable.coke
            ),
            Product(
                name = "Pepsi Can",
                unit = "330ml, Price",
                price = "$4.99",
                imageRes = R.drawable.pepsi
            )
        )
    }
}