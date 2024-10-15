package com.example.ortbetp3grupo5parcial.data

import com.example.ortbetp3grupo5parcial.R
import com.example.ortbetp3grupo5parcial.models.Product

class EggRepository {
    fun getAllData(): List<Product> {
        return listOf(
            Product(
                name = "Egg Chicken Red",
                unit = "4pcs, Price",
                price = "$1.99",
                imageRes = R.drawable.eggred
            ),
            Product(
                name = "Egg Chicken White",
                unit = "180g, Price",
                price = "$1.50",
                imageRes = R.drawable.eggwhite
            ),
            Product(
                name = "Egg Pasta",
                unit = "30gm, Price",
                price = "$15.99",
                imageRes = R.drawable.eggpasta
            ),
            Product(
                name = "Egg Noodles",
                unit = "2L, Price",
                price = "$15.99",
                imageRes =  R.drawable.eggnoodlered
            ),
            Product(
                name = "Mayonnais Eggles",
                unit = "325ml, Price",
                price = "$4.99",
                imageRes = R.drawable.mayonnais
            ),
            Product(
                name = "Egg Noodles",
                unit = "330ml, Price",
                price = "$4.99",
                imageRes = R.drawable.eggnoodle
            )
        )
    }
}