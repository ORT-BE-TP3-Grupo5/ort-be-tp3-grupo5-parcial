package com.example.ortbetp3grupo5parcial.screens.favorites


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.ortbetp3grupo5parcial.R
import com.example.ortbetp3grupo5parcial.data.FavoriteProductRepository
import com.example.ortbetp3grupo5parcial.ui.components.Footer
import com.example.ortbetp3grupo5parcial.ui.components.Header
import com.example.ortbetp3grupo5parcial.ui.components.OrderFailedDialog
import com.example.ortbetp3grupo5parcial.ui.components.SubmitReusableButton
import com.example.ortbetp3grupo5parcial.ui.components.favorites.FavoriteProduct
import com.example.ortbetp3grupo5parcial.ui.theme.Gray20

@Composable
fun FavoritesScreen(navController: NavController) {
    // Obtener el repositorio de productos favoritos
    val favoriteProductRepository = FavoriteProductRepository()
    val products = favoriteProductRepository.getAllData()

    var showOrderFailedDialog by remember { mutableStateOf(false) }
    when{
        showOrderFailedDialog -> OrderFailedDialog(
            onDismiss = { showOrderFailedDialog = false },
            onBackToHome = {
                showOrderFailedDialog = false
                navController.popBackStack("home", inclusive = false)
            },
            onRetry = {
                showOrderFailedDialog = false
                navController.navigate("orderReview")
            }
        )
    }

    Scaffold(
        topBar = {
            Header(
                text = "Favorite",
                onClickLeft = {},
                iconLeft = R.drawable.ic_leading,
            )
        },
        bottomBar = {
            Footer(navController = navController)
        }
    ) { innerPadding -> // Usa innerPadding aquí

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding) // Aplica el padding del Scaffold
        ) {
            // Lista de productos favoritos
            HorizontalDivider(color = Gray20, thickness = 1.dp, modifier = Modifier.padding(top = 24.dp))
            LazyColumn(
                modifier = Modifier.weight(1f) // Permite que la lista ocupe el espacio disponible
            ) {
                items(products) { product ->
                    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                        FavoriteProduct(product = product)

                        HorizontalDivider(color = Gray20, thickness = 1.dp)
                    }
                }
            }

            // Caja que contiene el botón y lo posiciona en el centro abajo
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp), // Añade padding en la parte inferior del botón
                contentAlignment = Alignment.Center
            ) {
                SubmitReusableButton(
                    buttonText = "Add All To Cart",
                    onClick = {showOrderFailedDialog = true}
                )
            }
        }
    }
}