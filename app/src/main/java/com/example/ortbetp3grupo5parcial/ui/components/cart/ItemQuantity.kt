package com.example.ortbetp3grupo5parcial.ui.components.cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ortbetp3grupo5parcial.R
import com.example.ortbetp3grupo5parcial.ui.components.QuantityButton


@Composable
fun ItemQuantity(
    onQuantityChange: (Int) -> Unit
) {
    var value by remember { mutableStateOf(1) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.width(134.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Botón de decremento (-)
        QuantityButton(onClick = {
            if (value > 1){
                value--
                onQuantityChange(value)
            }
         }, iconResource = R.drawable.ic_quantity_substract, invertedColors = true,
        disabled = value == 1)

        // Valor numérico entre los botones
        Text(
            text = value.toString(),
            fontSize = 16.sp,
            fontWeight =  FontWeight.Bold
        )
        // Botón de incremento (+)
        QuantityButton(onClick = {
            value++
            onQuantityChange(value)
        }, invertedColors = true)
    }
}
