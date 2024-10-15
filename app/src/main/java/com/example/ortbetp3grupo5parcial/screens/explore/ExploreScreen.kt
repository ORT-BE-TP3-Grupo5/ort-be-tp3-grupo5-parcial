package com.example.ortbetp3grupo5parcial.screens.explore

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ortbetp3grupo5parcial.ui.components.CategoryItem
import com.example.ortbetp3grupo5parcial.ui.components.Search
import com.example.ortbetp3grupo5parcial.R
import com.example.ortbetp3grupo5parcial.ui.components.Footer
import com.example.ortbetp3grupo5parcial.data.CategoryRepository
import com.example.ortbetp3grupo5parcial.ui.components.FiltersModal.FiltersModal
import com.example.ortbetp3grupo5parcial.ui.components.Header


@Composable
fun ExploreScreen(navController: NavController) {

    var isFilterDialogOpen by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            Header(
                text = "Find Products",
                onClickLeft = { navController.popBackStack() },
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
            CategoriesList(navController = navController)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
    if (isFilterDialogOpen) {
        FiltersModal(onDismiss = { isFilterDialogOpen = false })
    }
}

@Composable
fun CategoriesList(navController: NavController) {
    val categoryRepository  = CategoryRepository()
    val categories = categoryRepository.getAllData()
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

