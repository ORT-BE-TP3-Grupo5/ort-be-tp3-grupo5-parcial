package com.example.ortbetp3grupo5parcial.data

import com.example.ortbetp3grupo5parcial.R
import com.example.ortbetp3grupo5parcial.models.Category
import com.example.ortbetp3grupo5parcial.models.Product

class ProductBestRepository {
    fun getAllData(): List<Product> {
        return listOf(Product("Bell Pepper Red", "$2.99","7pcs, Priceg", R.drawable.pepper),
            Product("Ginger", "$1.99","7pcs, Priceg", R.drawable.ginger),
            Product("Unknown Best Seller", "$4.49","7pcs, Priceg", R.drawable.pepper))

    }}