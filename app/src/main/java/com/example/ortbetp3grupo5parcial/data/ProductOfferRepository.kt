package com.example.ortbetp3grupo5parcial.data

import com.example.ortbetp3grupo5parcial.R
import com.example.ortbetp3grupo5parcial.models.Category
import com.example.ortbetp3grupo5parcial.models.Product

class ProductOfferRepository {
    fun getAllData(): List<Product> {
        return listOf(
            Product("Organic Bananas", "$4.99","7pcs, Price", R.drawable.banana),
            Product("Red Apple", "$4.99","7pcs, Price", R.drawable.apple),
            Product("Ecuatorian Bananas", "$3.99","7pcs, Price", R.drawable.banana),
            Product("S White's Apple", "$14.99","1pcs, Price", R.drawable.apple)
        )
    }
}
