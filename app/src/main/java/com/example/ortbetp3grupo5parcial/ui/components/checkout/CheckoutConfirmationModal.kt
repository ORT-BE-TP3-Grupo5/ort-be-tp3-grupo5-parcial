package com.example.ortbetp3grupo5parcial.ui.components.checkout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ortbetp3grupo5parcial.R
import com.example.ortbetp3grupo5parcial.ui.components.SubmitReusableButton
import com.example.ortbetp3grupo5parcial.ui.theme.Gray20
import com.example.ortbetp3grupo5parcial.ui.theme.Gray60
import com.example.ortbetp3grupo5parcial.ui.theme.Gray80
import java.util.Locale


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckoutConfirmationModal(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    totalCost: Double = 0.00,
    onDeliveryClick: () -> Unit = {},
    onPaymentClick: () -> Unit = {},
    onPromoCodeClick: () -> Unit = {},
    onTotalCostClick: () -> Unit = {},

) {

    ModalBottomSheet(onDismissRequest = onDismissRequest) {
        Column() {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp)

            ) {
                Text(
                    text = "Checkout",
                    fontSize = 24.sp,
                    color = Gray80,
                    modifier = Modifier
                        .padding( horizontal = 16.dp)
                        .weight(1f)
                )
                IconButton(onClick = onDismissRequest,) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_remove),
                        contentDescription = "Close",
                        tint = Gray80,
                        modifier = Modifier.size(17.dp)
                    )
                }
            }

            HorizontalDivider(color = Gray20, thickness = 1.dp)

            //Items
            Column(modifier = Modifier.padding(horizontal = 12.dp)) {
                CheckoutItem(
                    label = "Delivery",
                    value = "Select Method",
                    onClick = onDeliveryClick
                )
                CheckoutItemDivider()
                CheckoutItem(
                    label = "Payment",
                    imageResource =  R.drawable.ic_card,
                    imageContentDescription = "Selected Payment Method",
                    onClick = onPaymentClick
                )
                CheckoutItemDivider()
                CheckoutItem(
                    label = "Promo Code",
                    value = "Pick discount",
                    onClick = onPromoCodeClick
                )
                CheckoutItemDivider()
                CheckoutItem(
                    label = "Total Cost",
                    value = String.format(Locale.US, "%.2f", totalCost),
                    onClick = onTotalCostClick
                )
                CheckoutItemDivider()
                Text(
                    text = "By placing an order you agree to our Terms and Conditions",
                    fontSize = 14.sp,
                    color = Gray60,
                    modifier = Modifier.padding(16.dp)
                )
                Box(modifier = Modifier.padding(16.dp)) {
                    SubmitReusableButton(buttonText = "Place Order", onClick = onConfirmation)
                }
            }
        }
    }
}

@Composable
fun CheckoutItemDivider(){
    HorizontalDivider(
        color = Gray20,
        thickness = 1.dp,
        modifier = Modifier
            .padding(horizontal = 24.dp)
    )
}