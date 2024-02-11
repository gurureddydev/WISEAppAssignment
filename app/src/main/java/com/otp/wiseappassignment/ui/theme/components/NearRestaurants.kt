package com.otp.wiseappassignment.ui.theme.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.otp.wiseappassignment.R

@Composable
fun NearRestaurants() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CustomText(
            text = stringResource(R.string.near_restaurants),
            textSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
        CustomText(
            text = stringResource(R.string.see_all),
            textSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
