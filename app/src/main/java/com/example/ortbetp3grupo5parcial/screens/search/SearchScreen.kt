package com.example.ortbetp3grupo5parcial.screens.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ortbetp3grupo5parcial.R
import com.example.ortbetp3grupo5parcial.data.EggRepository
import com.example.ortbetp3grupo5parcial.models.Product
import com.example.ortbetp3grupo5parcial.screens.explore.exploreRoute
import com.example.ortbetp3grupo5parcial.ui.components.FiltersModal.FiltersModal
import com.example.ortbetp3grupo5parcial.ui.components.Footer
import com.example.ortbetp3grupo5parcial.ui.components.Header
import com.example.ortbetp3grupo5parcial.ui.components.Search
import com.example.ortbetp3grupo5parcial.ui.components.product.ProductCard

@Composable
fun SearchScreen(navController: NavController) {

    var isFilterDialogOpen by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            Header(
                text = "Search",
                onClickLeft = { navController.navigateUp() },
                iconLeft = R.drawable.ic_leading
            )
        },
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
            Search(navController = navController, onFilterClick = { isFilterDialogOpen = true })
            Spacer(modifier = Modifier.height(16.dp))
            ProductsList(
                onProductClick = { product ->
                    navController.navigate("productDetail")
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
    if (isFilterDialogOpen) {
        FiltersModal(onDismiss = { isFilterDialogOpen = false })
    }
}
@Composable
fun ProductsList(
    onProductClick: (Product) -> Unit
) {
    val eggRepository = EggRepository()
    val products = eggRepository.getAllData()
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(products) { product ->
            ProductCard(
                product = product,
                onClick = { onProductClick(product) },

            )
        }
    }
}
