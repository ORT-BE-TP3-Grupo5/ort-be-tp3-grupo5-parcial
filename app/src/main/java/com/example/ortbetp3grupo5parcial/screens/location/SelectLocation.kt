package com.example.ortbetp3grupo5parcial.screens.location

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ortbetp3grupo5parcial.R
import com.example.ortbetp3grupo5parcial.data.AreaRepository
import com.example.ortbetp3grupo5parcial.data.ZonaRepository
import com.example.ortbetp3grupo5parcial.models.Area
import com.example.ortbetp3grupo5parcial.models.Zona
import com.example.ortbetp3grupo5parcial.screens.singup.signUpRoute
import com.example.ortbetp3grupo5parcial.ui.components.SubmitReusableButton

@Composable
fun SelectLocationScreen(navController: NavController) {

    var selectedZona by remember { mutableStateOf<Zona?>(null) }
    var selectedArea by remember { mutableStateOf<Area?>(null) }

    val zonas = ZonaRepository.getZonas()
    val areas = AreaRepository.getAreas()

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.fondo_blanco_y_rosa),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(420.83.dp)
                .height(896.dp)
        )

        Icon(
            painter = painterResource(id = R.drawable.icon_back),
            contentDescription = "Back Icon",
            modifier = Modifier
                .size(width = 10.dp, height = 18.dp)
                .offset(x = 25.01.dp, y = 56.83.dp)
                .clickable {
                    navController.navigate(signUpRoute)
                }
        )

        Image(
            painter = painterResource(id = R.drawable.location),
            contentDescription = null,
            modifier = Modifier
                .size(width = 224.69.dp, height = 170.69.dp)
                .offset(x = 94.66.dp, y = 119.8.dp),
            contentScale = ContentScale.Fit
        )

        Text(
            text = "Select Your Location",
            fontFamily = FontFamily(Font(R.font.poppins_semibold)),
            fontSize = 26.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF181725),
            modifier = Modifier
                .width(280.dp)
                .height(29.dp)
                .offset(x = 65.5.dp, y = 330.65.dp),
            textAlign = TextAlign.Center
        )

        Column(
            modifier = Modifier
                .offset(x = 20.19.dp, y = 385.65.dp)
                .width(380.dp)
        ) {
            Text(
                text = "Switch on your location to stay in tune with",
                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                fontSize = 16.sp,
                color = Color(0xFF7C7C7C),
                lineHeight = 20.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 0.dp)
            )

            Text(
                text = "what’s happening in your area",
                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                fontSize = 18.sp,
                color = Color(0xFF7C7C7C),
                lineHeight = 15.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(start = 30.dp)
            )

        }

        CustomDropdownMenu(
            items = zonas,
            selectedItem = selectedZona,
            onItemSelected = { zona -> selectedZona = zona },
            label = "Your Zone",
            placeholderText = "Select Your Zone",
            modifier = Modifier
                .fillMaxWidth()
                .offset(x = 9.88.dp, y = 521.dp),
            itemLabel = { it.nombre }
        )

        CustomDropdownMenu(
            items = areas,
            selectedItem = selectedArea,
            onItemSelected = { area -> selectedArea = area },
            label = "Your Area",
            placeholderText = "Types of your area",
            modifier = Modifier
                .fillMaxWidth()
                .offset(x = 9.88.dp, y = 629.55.dp),
            itemLabel = { it.nombre }
        )

        LocationButton(navController)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> CustomDropdownMenu(
    items: List<T>,
    selectedItem: T?,
    onItemSelected: (T) -> Unit,
    label: String,
    placeholderText: String,
    modifier: Modifier = Modifier,
    itemLabel: (T) -> String
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier = modifier
    ) {
        TextField(
            value = selectedItem?.let(itemLabel) ?: placeholderText,
            onValueChange = {},
            readOnly = true,
            label = {
                Text(
                    text = label,
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    color = Color(0xFF7C7C7C)
                )
            },
            trailingIcon = {
                IconButton(onClick = { expanded = !expanded }) {
                    Icon(
                        painter = painterResource(id = R.drawable.desplegable), // Reemplaza por tu icono
                        contentDescription = "Icono personalizado desplegable",
                        modifier = Modifier.size(width = 10.dp, height = 15.dp)
                    )
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.LightGray,
                unfocusedIndicatorColor = Color.LightGray,
                cursorColor = Color.Gray
            )
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            items.forEach { item ->
                DropdownMenuItem(
                    text = { Text(itemLabel(item)) },
                    onClick = {
                        onItemSelected(item)
                        expanded = false
                    }
                )
            }
        }
    }
}

@Composable
fun LocationButton(navController: NavController) {
    Box(
        modifier = Modifier
            .size(width = 364.dp, height = 67.dp)
            .offset(x = 25.dp, y = 748.45.dp)
    ) {
        SubmitReusableButton(
            buttonText = "Submit",
            buttonWidth = 364,
            buttonHeight = 67,
            onClick = {
                navController.navigate("homeScreen")
            }
        )
    }
}




