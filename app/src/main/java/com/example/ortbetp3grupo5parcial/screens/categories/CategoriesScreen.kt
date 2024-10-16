package com.example.ortbetp3grupo5parcial.screens.categories

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ortbetp3grupo5parcial.R
import com.example.ortbetp3grupo5parcial.data.BeverageRepository
import com.example.ortbetp3grupo5parcial.models.Product
import com.example.ortbetp3grupo5parcial.screens.explore.exploreRoute
import com.example.ortbetp3grupo5parcial.ui.components.Header
import com.example.ortbetp3grupo5parcial.ui.components.product.ProductCard

@Composable
fun CategoriesScreen(navController: NavController) {
    Scaffold(
        topBar = {
            Header(
                text = "Beverages",
                onClickLeft = { navController.navigateUp() },
                iconLeft = R.drawable.ic_back
            )
        },
    ) { innerPadding ->
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(8.dp),
            contentAlignment = Alignment.TopCenter
        ) {

            ProductsList(
                onProductClick = { product ->
                    navController.navigate("productDetail")
                }
            )
        }
        Spacer(modifier = Modifier.height(70.dp))
    }
}
@Composable
fun ProductsList(
    onProductClick: (Product) -> Unit
) {
    val beverageRepository  = BeverageRepository()
    val products = beverageRepository.getAllData()
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(products) { product ->
            ProductCard(
                product = product,
                onClick = { onProductClick(product) },
            )
        }
    }
}
