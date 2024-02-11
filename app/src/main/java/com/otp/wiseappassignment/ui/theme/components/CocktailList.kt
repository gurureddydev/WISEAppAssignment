package com.otp.wiseappassignment.ui.theme.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.otp.wiseappassignment.data.model.Cocktail

@Composable
fun CocktailList(cocktailList: List<Cocktail>, onCocktailClick: (Cocktail) -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(cocktailList) { cocktail ->
            CustomItemCard(
                imageUrl = cocktail.strDrinkThumb,
                title = cocktail.strDrink,
                subtitle = cocktail.strCategory ?: "",
                price = "",
                onClick = { onCocktailClick(cocktail) }
            )
        }
    }
}
