package com.example.ortbetp3grupo5parcial.screens.productDetail

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.ortbetp3grupo5parcial.ui.theme.Gray20
import com.example.ortbetp3grupo5parcial.ui.theme.Gray60
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ortbetp3grupo5parcial.R
import com.example.ortbetp3grupo5parcial.data.ProductDetailRepository
import com.example.ortbetp3grupo5parcial.ui.components.SubmitReusableButton
import com.example.ortbetp3grupo5parcial.ui.components.cart.ItemQuantity
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.runtime.*
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.ui.draw.clip
import com.example.ortbetp3grupo5parcial.screens.home.homeRoute
import com.example.ortbetp3grupo5parcial.ui.components.Header

@Composable
fun ProductDetailScreen(navController: NavController) {
    Scaffold(
        topBar = {
            Header(
                text = "Shop",
                onClickLeft = { navController.popBackStack() }, // Acción de navegación
                iconLeft = R.drawable.ic_back
            )
        }
    ) { innerPadding -> // Usar innerPadding para manejar padding del Scaffold
        val product = ProductDetailRepository().getProduct()
        val context = LocalContext.current // Para mostrar el Toast

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding) // Aplicar el innerPadding
        ) {
            // Contenido principal de la pantalla
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(bottom = 70.dp) // Deja espacio para el botón "Add To Basket"
            ) {
                // Carrusel de imágenes
                Box {
                    CustomImageCarousel()

                    // Ícono de compartir superpuesto en la parte superior derecha
                    Image(
                        painter = painterResource(id = R.drawable.share),
                        contentDescription = "Share",
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(16.dp)
                            .size(20.dp)
                            .clickable {
                                // Acción de compartir
                            }
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Nombre del producto y favoritos
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = product.name,
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        modifier = Modifier.weight(1f)
                    )

                    // Ícono de favoritos
                    Image(
                        painter = painterResource(id = R.drawable.favorite),
                        contentDescription = "Favorite",
                        modifier = Modifier
                            .size(28.dp)
                            .clickable {
                                // Acción de favoritos
                            }
                    )
                }

                // Detalle del producto (peso)
                Text(
                    text = product.unit,
                    fontSize = 14.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Selección de cantidad y precio
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Selector de cantidad
                    ItemQuantity(onQuantityChange = { newQuantity ->
                        // Lógica para cambio de cantidad
                    })

                    // Precio del producto
                    Text(
                        text = product.price,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }

                Divider(
                    color = Gray20,
                    thickness = 1.dp,
                    modifier = Modifier.padding(vertical = 12.dp, horizontal = 16.dp)
                )

                // Sección de detalles del producto
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 7.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Product Detail",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Image(
                        painter = painterResource(id = R.drawable.arrow_down),
                        contentDescription = "Arrow",
                        modifier = Modifier.size(16.dp)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = product.description,
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    modifier = Modifier.padding(horizontal = 16.dp),
                    color = Gray60
                )

                Spacer(modifier = Modifier.height(16.dp))

                Divider(
                    color = Gray20,
                    thickness = 1.dp,
                    modifier = Modifier.padding(vertical = 4.dp, horizontal = 16.dp)
                )

                // Sección de Nutrición
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Nutritions",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        // Imagen de nutrición
                        Image(
                            painter = painterResource(id = product.gramsImage),
                            contentDescription = "Nutrition Icon",
                            modifier = Modifier.size(35.dp),
                            contentScale = ContentScale.Fit
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Image(
                            painter = painterResource(id = R.drawable.arrow),
                            contentDescription = "Arrow",
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }

                Divider(
                    color = Gray20,
                    thickness = 1.dp,
                    modifier = Modifier.padding(vertical = 4.dp, horizontal = 16.dp)
                )

                // Sección de Review
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Review",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        // Estrellas de review
                        Image(
                            painter = painterResource(id = product.reviewImage),
                            contentDescription = "Review Stars",
                            modifier = Modifier.size(35.dp),
                            contentScale = ContentScale.Fit
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Image(
                            painter = painterResource(id = R.drawable.arrow),
                            contentDescription = "Arrow",
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))
            }

            // Botón "Add to Basket"
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                SubmitReusableButton(
                    onClick = {
                        Toast.makeText(context, "Se agregó al carrito", Toast.LENGTH_SHORT).show()
                    },
                    buttonText = "Add To Basket"
                )
            }
        }
    }
}

@Composable
fun CustomImageCarousel() {
    val product = ProductDetailRepository().getProduct()
    val images = product.productImages

    var currentImageIndex by remember { mutableStateOf(0) }
    var dragOffset by remember { mutableStateOf(0f) }
    val dragThreshold = 100f

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f) // Mantener aspecto cuadrado
            .clip(RoundedCornerShape(8.dp)) // Bordes redondeados
            .height(80.dp) // Altura reducida del carrusel
    ) {
        Image(
            painter = painterResource(id = images[currentImageIndex]),
            contentDescription = "Carousel Image",
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            contentScale = ContentScale.Fit
        )

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 8.dp), // Reducir el padding
            horizontalArrangement = Arrangement.Center
        ) {
            images.forEachIndexed { index, _ ->
                Box(
                    modifier = Modifier
                        .width(if (index == currentImageIndex) 12.dp else 5.dp) // Cambiar el tamaño de los indicadores
                        .height(5.dp)
                        .clip(CircleShape)
                        .background(if (index == currentImageIndex) Color(0xFF54B474) else Color.LightGray)
                )

                if (index < images.size - 1) {
                    Spacer(modifier = Modifier.width(4.dp)) // Reducir el espacio entre indicadores
                }
            }
        }

        // Deslizamiento para cambiar imagen
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



