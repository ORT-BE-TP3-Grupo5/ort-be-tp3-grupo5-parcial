package com.example.ortbetp3grupo5parcial.screens.explore

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ortbetp3grupo5parcial.ui.components.CategoryItem
import com.example.ortbetp3grupo5parcial.ui.components.Search
import com.example.ortbetp3grupo5parcial.R
import com.example.ortbetp3grupo5parcial.models.Category
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import com.example.ortbetp3grupo5parcial.ui.components.Footer

@Composable
fun ExploreScreen(navController: NavController) {
    Scaffold(
        bottomBar = {
            Footer(navController = navController)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(8.dp)
        ) {
            Spacer(modifier = Modifier.height(8.dp))
            Search(navController = navController)
            Spacer(modifier = Modifier.height(16.dp))
            CategoriesList(navController = navController)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun CategoriesList(navController: NavController) {
    val categories = listOf(
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

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(categories) { category ->
            CategoryItem(
                backgroundColor = category.backgroundColor,
                borderColor = category.borderColor,
                imageResId = category.imageResId,
                title = category.title,
                onClick = {
                    navController.navigate(category.route)
                }
            )
        }
    }
}

