package com.example.ortbetp3grupo5parcial.screens.account

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ortbetp3grupo5parcial.R
import com.example.ortbetp3grupo5parcial.ui.components.Header
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.ortbetp3grupo5parcial.ui.components.Footer
import com.example.ortbetp3grupo5parcial.ui.theme.Gray20
import com.example.ortbetp3grupo5parcial.ui.theme.Gray60
import com.example.ortbetp3grupo5parcial.ui.theme.Gray80
import com.example.ortbetp3grupo5parcial.ui.theme.Gray90
import com.example.ortbetp3grupo5parcial.ui.theme.Green40


@Composable
fun AccountScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Header(
            text = "Account",
            iconLeft = R.drawable.ic_leading,
            onClickLeft = { }
        )
        AccountProfile( name ="Pepe", email= "juanpepe@gmail.com", imageResource = R.drawable.bakery, onClick = { })
        Spacer(modifier = Modifier.height(18.dp))
        HorizontalDivider(color = Gray20, thickness = 1.dp)
        LazyColumn(Modifier.weight(1f))  {
            item{ AccountItem( iconResource = R.drawable.ic_orders, label = "Orders", onClick = { }) }
            item{ AccountItem( iconResource = R.drawable.my_details_icon, label = "My Details", onClick = { }) }
            item{ AccountItem( iconResource = R.drawable.ic_delivery_address, label = "Delivery Address", onClick = { }) }
            item{ AccountItem( iconResource = R.drawable.ic_payment_methods, label = "Payment Methods", onClick = { }) }
            item{ AccountItem( iconResource = R.drawable.promo_cord_icon, label = "Promo Card", onClick = { }) }
            item{ AccountItem( iconResource = R.drawable.notificationsl_icon, label = "Notifications", onClick = { }) }
            item{ AccountItem( iconResource = R.drawable.help_icon, label = "Help", onClick = { }) }
        }
        Footer(navController = navController)
    }


}

@Composable
fun AccountItem(
    iconResource: Int,
    iconContentDescription: String = "Icon",
    label: String,
    onClick: () -> Unit
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = iconResource),
            contentDescription = iconContentDescription,
            modifier = Modifier
                .padding(start = 16.dp, end = 24.dp)
                .width(20.dp)
        )
        Text(
            text = label,
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            color = Gray90,
            modifier = Modifier
                .weight(1f)

        )
        IconButton(
            onClick = onClick,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_next),
                contentDescription = "Open Item",
                modifier = Modifier
                    .size(14.dp)
            )
        }
    }
    HorizontalDivider(color = Gray20, thickness = 1.dp, modifier = Modifier.padding(horizontal = 24.dp) )
}


@Composable
fun AccountProfile(
    imageResource: Int,
    name: String,
    email: String,
    onClick: () -> Unit
){
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Column {
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = "Profile Image",
                modifier = Modifier
                    .padding( horizontal = 24.dp, vertical = 8.dp)
                    .size(64.dp)
                    .clip(RoundedCornerShape(27.dp))

            )
        }
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically){
                Text(
                    text = name,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Gray80,
                    modifier = Modifier //.padding(start = 16.dp)
                )
                IconButton(
                    onClick = onClick,
                    modifier = Modifier.padding(start = 4.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_edit),
                        contentDescription = "Editar perfil",
                        tint = Green40,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
            Row(){
                Text(
                    text = email,
                    fontSize = 16.sp,
                    color = Gray60,
                    //modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
    }
}
