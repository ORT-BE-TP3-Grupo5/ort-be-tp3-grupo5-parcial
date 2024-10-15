package com.example.ortbetp3grupo5parcial.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Scaffold
import androidx.navigation.NavController
import com.example.ortbetp3grupo5parcial.R
import com.example.ortbetp3grupo5parcial.data.ProductBestRepository
import com.example.ortbetp3grupo5parcial.data.ProductOfferRepository
import com.example.ortbetp3grupo5parcial.models.Product
import com.example.ortbetp3grupo5parcial.ui.components.Footer
import com.example.ortbetp3grupo5parcial.ui.components.Header
import com.example.ortbetp3grupo5parcial.ui.components.product.ProductSection
import com.example.ortbetp3grupo5parcial.ui.theme.OrtBeTp3Grupo5ParcialTheme

@Composable
fun HomeScreen(navController: NavController) {

    val productOfferRepository  = ProductOfferRepository()
    val products = productOfferRepository.getAllData()

    val productBestRepository  = ProductBestRepository()
    val products2 = productBestRepository.getAllData()

    // Scroll vertical para toda la pantalla
    Scaffold(
        topBar = {
            Header(
                text = "Shop",
                onClickLeft = {},
                iconLeft = R.drawable.ic_leading,
                    )
                 },
        bottomBar = {
            Footer(navController = navController)
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .background(Color.White)
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(8.dp)
                    .background(Color.White)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {
                    // Sección de cabecera
                    HeaderSection()



                    // Sección de "Exclusive Offer"
                    ProductSection(
                        title = "Exclusive Offer",
                        products = products,
                        navController = navController
                    )

                    // Sección de "Best Selling"
                    ProductSection(
                        title = "Best Selling",
                        products = products2,
                        navController = navController
                    )
                }
            }
        }
    }
}



@Composable
fun HeaderSection() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Ciudad
        Text(
            text = "Dhaka, Banassre",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(16.dp),
            color = Color(0xFF4C4F4D)
        )

        // Carrusel de imágenes con padding a los costados
        CustomImageCarousel()
    }
}

@Composable
fun CustomImageCarousel() {
    val images = listOf(
        R.drawable.banner,
        R.drawable.apple,
        R.drawable.banana
    )

    var currentImageIndex by remember { mutableStateOf(0) }
    var dragOffset by remember { mutableStateOf(0f) }
    val dragThreshold = 100f

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(horizontal = 23.dp) // Padding a los costados
    ) {
        Image(
            painter = painterResource(id = images[currentImageIndex]),
            contentDescription = "Carousel Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Fit, // Cambia a Fit para que la imagen no se recorte
        )

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 28.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            images.forEachIndexed { index, _ ->
                Box(
                    modifier = Modifier
                        .width(if (index == currentImageIndex) 22.dp else 7.dp)
                        .height(7.dp)
                        .clip(CircleShape)
                        .background(if (index == currentImageIndex) Color(0xFF54B474) else Color.LightGray)
                )

                if (index < images.size - 1) {
                    Spacer(modifier = Modifier.width(7.dp))
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectHorizontalDragGestures { _, dragAmount ->
                        dragOffset += dragAmount
                        if (dragOffset > dragThreshold) {
                            currentImageIndex = (currentImageIndex - 1 + images.size) % images.size
                            dragOffset = 0f
                        } else if (dragOffset < -dragThreshold) {
                            currentImageIndex = (currentImageIndex + 1) % images.size
                            dragOffset = 0f
                        }
                    }
                }
        )
    }
}

