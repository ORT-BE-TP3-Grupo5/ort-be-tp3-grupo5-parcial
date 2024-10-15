package com.example.ortbetp3grupo5parcial.data

import com.example.ortbetp3grupo5parcial.R
import com.example.ortbetp3grupo5parcial.models.ProductDetailModel

class ProductDetailRepository {

    fun getProduct(): ProductDetailModel {
        return ProductDetailModel(
            name = "Naturel Red Apple",
            price = "$4.99",
            unit = "1kg, Price",
            productImages = listOf(R.drawable.big_apple,R.drawable.big_apple, R.drawable.banana), // Lista de imágenes del producto
            description = "Apples Are Nutritious. Apples May Be Good For Weight Loss. Apples May Be Good For Your Heart. As Part Of Heatful And Varied Diet",
            gramsImage = R.drawable.grams,
            reviewImage = R.drawable.review
        )
    }

}