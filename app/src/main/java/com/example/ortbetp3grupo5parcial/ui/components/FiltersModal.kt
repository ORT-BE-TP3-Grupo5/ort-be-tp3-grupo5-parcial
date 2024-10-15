package com.example.ortbetp3grupo5parcial.ui.components.FiltersModal

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.ortbetp3grupo5parcial.R
import com.example.ortbetp3grupo5parcial.ui.components.Header
import com.example.ortbetp3grupo5parcial.ui.components.SubmitReusableButton
import com.example.ortbetp3grupo5parcial.ui.theme.Gray15
import com.example.ortbetp3grupo5parcial.ui.theme.Gray30
import com.example.ortbetp3grupo5parcial.ui.theme.Gray80

@Composable
fun FiltersModal(onDismiss: () -> Unit) {
    Dialog(
        onDismissRequest = { onDismiss() },
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Header(
                    text = "Filters",
                    onClickLeft = { onDismiss() },
                    iconLeft = R.drawable.ic_close
                )

                Spacer(modifier = Modifier.height(16.dp))

                Column (
                    modifier = Modifier
                        .weight(1f)
                        .clip(
                            RoundedCornerShape(
                                topStart = 30.dp,
                                topEnd = 30.dp,
                                bottomStart = 0.dp,
                                bottomEnd = 0.dp
                            )
                        )
                        .background(Gray15)
                        .padding(horizontal = 20.dp, vertical = 20.dp)
                ){
                    Text(
                        "Categories",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp,
                            color = Gray80
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    CategoryCheckbox("Eggs", true)
                    CategoryCheckbox("Noodles & Pasta")
                    CategoryCheckbox("Chips & Crisps")
                    CategoryCheckbox("Fast Food")

                    Spacer(modifier = Modifier.height(24.dp))

                    Text(
                        "Brand",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp,
                            color = Gray80
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    CategoryCheckbox("Individual Collection")
                    CategoryCheckbox("Cocola", )
                    CategoryCheckbox("Ifad")
                    CategoryCheckbox("Kazi Farmas")
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 36.dp),
                    horizontalArrangement = Arrangement.Center
                ){
                    SubmitReusableButton(
                        onClick = { onDismiss() },
                        buttonText = "Apply Filter",
                    )
                }

            }
        }
    }
}

@Composable
fun CategoryCheckbox(text: String, checkedState: Boolean = false) {
    var isChecked by remember { mutableStateOf(checkedState) }

    val checkboxSize = 24.dp
    val borderWidth = 1.5.dp
    val cornerRadius = 8.dp
    val borderColor = Gray30

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(checkboxSize)
                .clip(RoundedCornerShape(cornerRadius))
                .border(borderWidth, borderColor, RoundedCornerShape(cornerRadius))
                .background(
                    if (isChecked) Color(0xFF53B175) else Color.Transparent
                )
                .clickable { isChecked = !isChecked }
        ) {
            if (isChecked) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_tilde),
                    contentDescription = "Selected",
                    tint = Color.White,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = 16.sp,
                fontWeight = if (isChecked) FontWeight.SemiBold else FontWeight.Normal,
                color = if (isChecked) Color(0xFF53B175) else Color(0xFF181725)
            )
        )
    }
}