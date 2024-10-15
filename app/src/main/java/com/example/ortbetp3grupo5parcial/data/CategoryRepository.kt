package com.example.ortbetp3grupo5parcial.data

import androidx.compose.ui.graphics.Color
import com.example.ortbetp3grupo5parcial.R
import com.example.ortbetp3grupo5parcial.models.Category

class CategoryRepository {
    fun getAllData(): List<Category> {
        return listOf(
            Category(
                backgroundColor = Color(0x1953B175),
                borderColor = Color(0xB253B175),
                imageResId = R.drawable.fruits,
                title = "Fresh Fruits & Vegetable",
                route = "categories"
            ),
            Category(
                backgroundColor = Color(0x19F8A44C),
                borderColor = Color(0xB2F8A44C),
                imageResId = R.drawable.oil,
                title = "Cooking Oil & Ghee",
                route = "categories"
            ),
            Category(
                backgroundColor = Color(0x3FF7A593),
                borderColor = Color(0xFFF7A593),
                imageResId = R.drawable.meat,
                title = "Meat & Fish",
                route = "categories"
            ),
            Category(
                backgroundColor = Color(0x3FD3B0E0),
                borderColor = Color(0xFFD3B0E0),
                imageResId = R.drawable.bakery,
                title = "Bakery & Snacks",
                route = "categories"
            ),
            Category(
                backgroundColor = Color(0x3FFDE598),
                borderColor = Color(0xFFFDE598),
                imageResId = R.drawable.eggs,
                title = "Dairy & Eggs",
                route = "categories"
            ),
            Category(
                backgroundColor = Color(0x3FB7DFF5),
                borderColor = Color(0xFFB7DFF5),
                imageResId = R.drawable.beverages,
                title = "Beverages",
                route = "categories"
            )
        )
    }
}