package com.example.ortbetp3grupo5parcial.screens.order

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ortbetp3grupo5parcial.R
import com.example.ortbetp3grupo5parcial.ui.components.ButtonGroup
import com.example.ortbetp3grupo5parcial.ui.components.MessageDisplay


@Composable
fun OrderReviewScreen(navController: NavController) {

    Box(modifier = Modifier.fillMaxSize())
    {
        Image(
            painter = painterResource(id = R.drawable.fondo_blanco_y_rosa),
            contentDescription = "Fondo blanco y rosa",
            modifier = Modifier.fillMaxSize()
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .weight(1f)
                    .padding(40.dp)
                    .verticalScroll(rememberScrollState()),
            ) {
                SuccessImage()
                Spacer(modifier = Modifier.height(52.dp))
                MessageDisplay(
                    title = "Your order has been accepted",
                    message = "Your items has been placed and is on it’s way to being processed"
                )
            }
            //Botonera
            ButtonGroup(
                submitLabel = "Track Order",
                backLabel = "Back to home",
                onSubmit = { navController.navigate("checkout")},
                onBack = { navController.navigate("home") }
            )
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun SuccessImage(){
    Image(
        painter = painterResource(id = R.drawable.success),
        contentDescription = "Order Accepted",
        modifier = Modifier.padding(end = 42.dp)
    )
}