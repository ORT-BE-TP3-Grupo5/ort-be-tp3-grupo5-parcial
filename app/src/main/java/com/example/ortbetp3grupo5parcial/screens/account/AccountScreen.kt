package com.example.ortbetp3grupo5parcial.screens.account

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ortbetp3grupo5parcial.R
import com.example.ortbetp3grupo5parcial.ui.components.Header
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ortbetp3grupo5parcial.screens.signin.signInRoute
import com.example.ortbetp3grupo5parcial.ui.components.Footer
import com.example.ortbetp3grupo5parcial.ui.theme.Gray15
import com.example.ortbetp3grupo5parcial.ui.theme.Gray20
import com.example.ortbetp3grupo5parcial.ui.theme.Gray60
import com.example.ortbetp3grupo5parcial.ui.theme.Gray80
import com.example.ortbetp3grupo5parcial.ui.theme.Gray90
import com.example.ortbetp3grupo5parcial.ui.theme.Green40


@Composable
fun AccountScreen(navController: NavController) {
    var isDarkMode by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Header(
            text = "Account",
            iconLeft = R.drawable.ic_leading,
            onClickLeft = { }
        )
        AccountProfile(
            name = "Afsar Hossen",
            email = "Imshuvo97@gmail.com",
            imageResource = R.drawable.perfil,
            onClick = { }
        )
        Spacer(modifier = Modifier.height(18.dp))
        HorizontalDivider(color = Gray20, thickness = 1.dp)

        Column(Modifier.weight(1f).verticalScroll(rememberScrollState())) {
            AccountItem(iconResource = R.drawable.ic_orders, label = "Orders", onClick = { })
            AccountItem(iconResource = R.drawable.my_details_icon, label = "My Details", onClick = { })
            AccountItem(iconResource = R.drawable.ic_delivery_address, label = "Delivery Address", onClick = { })
            AccountItem(iconResource = R.drawable.ic_payment_methods, label = "Payment Methods", onClick = { })
            AccountItem(iconResource = R.drawable.promo_cord_icon, label = "Promo Card", onClick = { })
            AccountItem(iconResource = R.drawable.notificationsl_icon, label = "Notifications", onClick = { })
            AccountItem(iconResource = R.drawable.help_icon, label = "Help", onClick = { })
            DarkMode(isDarkMode = isDarkMode, onCheckedChange = { isDarkMode = it })
            Spacer(modifier = Modifier.height(48.dp))
            Row( modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                LogOutButton(navController)
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
        Footer(navController = navController)
    }
}

@Composable
fun DarkMode(isDarkMode: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(56.dp))
        Text(text = "Dark mode",
            fontSize = 18.sp,
            fontFamily = FontFamily(Font(R.font.poppins_medium)),
            modifier = Modifier
                .weight(1f))
        Switch(
            checked = isDarkMode,
            onCheckedChange = { onCheckedChange(it) },
            colors = SwitchDefaults.colors(
                uncheckedThumbColor = Color.White,
                uncheckedTrackColor = Color(0xFFC0C0C0),
                uncheckedBorderColor = Color.Transparent,
                checkedBorderColor = Color.Transparent
            ))
    }
    HorizontalDivider(color = Gray20, thickness = 1.dp, modifier = Modifier.padding(horizontal = 24.dp) )
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
            fontFamily = FontFamily(Font(R.font.poppins_medium)),
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
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
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


@Composable
fun LogOutButton(navController: NavController) {
    Button(
        onClick = {
            navController.navigate(signInRoute)
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = Gray15
        ),
        modifier = Modifier
            .width(364.dp)
            .height(67.dp)
            .clip(RoundedCornerShape(19.dp))
            .background(Gray15)

    ) {
        Box( modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier
                .align(Alignment.Center),
                horizontalArrangement = Arrangement.Center) {
                Text(
                    text = "Log Out",
                    color = Green40,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    textAlign = TextAlign.Center
                )
            }

            Row(
                modifier = Modifier.align(Alignment.CenterStart)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_got_out),
                    contentDescription = "Log Out Icon",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(24.dp)
                        .padding(end = 8.dp)
                )
            }

        }
    }
}

