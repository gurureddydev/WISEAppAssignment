package com.otp.wiseappassignment.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.otp.wiseappassignment.R
import com.otp.wiseappassignment.data.model.Cocktail
import com.otp.wiseappassignment.ui.theme.components.CustomText

@Composable
fun CocktailDetailsScreen(
    navController: NavController,
    cocktail: Cocktail?,
) {
    cocktail?.let {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(),
            color = MaterialTheme.colorScheme.background,
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()) // Make the column scrollable
            ) {
                // Back Button
                IconButton(
                    onClick = {
                        navController.popBackStack()
                    },
                    modifier = Modifier
                        .align(Alignment.Start)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = stringResource(R.string.back),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Cocktail Image
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current).data(it.strDrinkThumb)
                        .crossfade(true)
                        .build(),
                    contentDescription = stringResource(R.string.cocktail_image),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(8.dp))
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Cocktail Title
                CustomText(
                    text = it.strDrink,
                    textSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Cocktail Category
                CustomText(
                    text = stringResource(R.string.category, it.strCategory ?: ""),
                    textSize = 16.sp,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Instructions
                CustomText(
                    text = stringResource(R.string.instructions),
                    textSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                CustomText(
                    text = it.strInstructions ?: "",
                    textSize = 16.sp,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Ingredients
                CustomText(
                    text = stringResource(R.string.ingredients),
                    textSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                // Add your ingredient logic here
                for (i in 1..15) {
                    val ingredient = it.strIngredient1
                    val measure = it.strMeasure1
                    if (!ingredient.isNullOrBlank() && !measure.isNullOrBlank()) {
                        CustomText(
                            text = "$ingredient: $measure",
                            textSize = 16.sp,
                            color = Color.Gray
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Thumbnail and Measure
                CustomText(
                    text = stringResource(R.string.thumbnail_and_measure),
                    textSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                it.strDrinkThumb.let { thumbAndMeasure ->
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(thumbAndMeasure)
                                .crossfade(true)
                                .build(),
                            contentDescription = "Thumbnail",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(0.7f) // Adjust the weight for the image
                                .clip(RoundedCornerShape(8.dp))
                        )
                    }
                }
                it.strMeasure1?.let { it1 ->
                    CustomText(
                        text = it1,
                        textSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}
