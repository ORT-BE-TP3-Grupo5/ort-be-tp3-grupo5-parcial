package com.example.ortbetp3grupo5parcial.data
import com.example.ortbetp3grupo5parcial.R
import com.example.ortbetp3grupo5parcial.models.FavoriteItem


class FavoriteProductRepository {

    fun getAllData(): List<FavoriteItem> {
        return listOf(
            FavoriteItem("Sprite Can", "325ml, Price", "$1.50", R.drawable.sprite),
            FavoriteItem("Diet Coke", "355ml, Price", "$1.99", R.drawable.diet),
            FavoriteItem("Apple & Grape Juice", "2L, Price", "$15.50", R.drawable.juice),
            FavoriteItem("Coca Cola Can", "325ml, Price", "$4.99", R.drawable.coke),
            FavoriteItem("Pepsi Can", "330ml, Price", "$4.99", R.drawable.pepsi)

        )

    }


}