package com.otp.wiseappassignment.ui.theme.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.otp.wiseappassignment.R
import com.otp.wiseappassignment.ui.theme.CardBackgroundColor

@Composable
fun BlueRestaurant() {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .background(color = CardBackgroundColor)
            .clip(RoundedCornerShape(10)),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10))
        ) {
            Spacer(modifier = Modifier.width(16.dp))
            BlueRestaurantImage()
            BlueRestaurantDetails()
        }
    }
}

@Composable
fun BlueRestaurantImage() {
    Image(
        painter = painterResource(id = R.drawable.blue_res),
        contentDescription = stringResource(R.string.steve_st_rood),
        modifier = Modifier
            .width(130.dp)
            .height(120.dp)
            .clip(RoundedCornerShape(15.dp))
    )
}

@Composable
fun BlueRestaurantDetails() {
    Column(
        modifier = Modifier
            .padding(start = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(R.string.blue_restaurant),
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = stringResource(R.string._10_00am_03_30pm),
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(
                fontSize = 15.sp
            )
        )

        BlueRestaurantRating()
    }
}

@Composable
fun BlueRestaurantRating() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = stringResource(R.string.steve_st_rood),
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Red
            ),
        )
        Spacer(modifier = Modifier.width(20.dp))
        Text(
            text = stringResource(R.string._4_5),
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            ),
            modifier = Modifier.align(Alignment.CenterVertically)
        )
        Spacer(modifier = Modifier.width(5.dp))
        Icon(
            imageVector = Icons.Filled.Star,
            contentDescription = stringResource(R.string.rating_star),
            tint = Color.Yellow
        )
    }
}
