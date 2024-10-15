package com.example.ortbetp3grupo5parcial.models

data class ProductDetailModel(
    val name: String,
    val price: String,
    val unit: String,
    val productImages: List<Int>, // Cambia a lista de imágenes
    val description: String,
    val gramsImage: Int,
    val reviewImage: Int
)
