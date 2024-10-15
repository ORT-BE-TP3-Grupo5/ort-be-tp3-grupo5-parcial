package com.example.ortbetp3grupo5parcial.ui.components.checkout

import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
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
                    .padding(bottom = 24.dp, start = 16.dp, end = 16.dp)

            ) {
                Text(
                    text = "Checkout",
                    fontSize = 24.sp,
                    color = Gray80,
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
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
                    onClick = onDeliveryClick,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                CheckoutItemDivider()
                CheckoutItem(
                    label = "Payment",
                    imageResource =  R.drawable.ic_card,
                    imageContentDescription = "Selected Payment Method",
                    onClick = onPaymentClick,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                CheckoutItemDivider()
                CheckoutItem(
                    label = "Promo Code",
                    value = "Pick discount",
                    onClick = onPromoCodeClick,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                CheckoutItemDivider()
                CheckoutItem(
                    label = "Total Cost",
                    value = String.format(Locale.US, "%.2f", totalCost),
                    onClick = onTotalCostClick,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                CheckoutItemDivider()
                TermsAndConditionsText(modifier = Modifier.padding(16.dp).fillMaxWidth(0.8f))
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

@Composable
fun TermsAndConditionsText( modifier: Modifier = Modifier, onClick: () -> Unit = {}){
    val termsAndConditionsText = buildAnnotatedString {
        append("By placing an order you agree to our ")

        // Estilo para "Terms"
        withStyle(style = SpanStyle(
            color = Gray80,
            fontWeight = FontWeight.SemiBold,
        )
        ) {
            append("Terms")
        }

        append(" And ")

        // Estilo para "Conditions"
        withStyle(style = SpanStyle(
            color = Gray80,
            fontWeight = FontWeight.SemiBold,
        )) {
            append("Conditions")
        }
    }

    Text(
        text = termsAndConditionsText,
        fontSize = 14.sp,
        lineHeight = 21.sp,
        fontFamily = FontFamily(Font(R.font.poppins_regular)),
        color = Gray60,
        modifier = modifier.clickable {
            onClick()
        }
    )
}