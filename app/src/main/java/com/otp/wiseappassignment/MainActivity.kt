package com.otp.wiseappassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.otp.wiseappassignment.data.model.Cocktail
import com.otp.wiseappassignment.data.model.Screen
import com.otp.wiseappassignment.ui.theme.WISEAppAssignmentTheme
import com.otp.wiseappassignment.ui.theme.components.BlueRestaurant
import com.otp.wiseappassignment.ui.theme.components.CocktailList
import com.otp.wiseappassignment.ui.theme.components.CustomText
import com.otp.wiseappassignment.ui.theme.components.NearRestaurants
import com.otp.wiseappassignment.ui.theme.components.SearchBar
import com.otp.wiseappassignment.ui.theme.screens.CocktailDetailsScreen
import com.otp.wiseappassignment.ui.theme.viewmodel.CocktailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: CocktailViewModel by viewModels()

    companion object {
        const val COCKTAIL = "y"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val cocktailList by viewModel.cocktailList.observeAsState(initial = emptyList())
            WISEAppAssignmentTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Screen.Home.route) {
                    composable(Screen.Home.route) {
                        MyApp(navController, viewModel = viewModel, cocktailList)
                    }

                    composable(Screen.Details.route + "/{idDrink}") { backStackEntry ->
                        val idDrink = backStackEntry.arguments?.getString("idDrink")
                        val selectedCocktail = cocktailList.find { it.idDrink == idDrink }

                        if (selectedCocktail != null) {
                            CocktailDetailsScreen(
                                navController, selectedCocktail
                            )
                        } else {
                            Text(getString(R.string.sorry_the_selected_cocktail_could_not_be_found))
                        }
                    }
                }
            }
        }

        viewModel.searchCocktail(COCKTAIL)
    }
}

@Composable
fun MyApp(
    navController: NavHostController,
    viewModel: CocktailViewModel,
    cocktailList: List<Cocktail>
) {
    val isLoading by viewModel.isLoading.observeAsState(initial = true)

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(),
        color = MaterialTheme.colorScheme.background,
    ) {
        Column(
            modifier = Modifier
                .padding(start = 16.dp)
        ) {
            Header()
            Spacer(modifier = Modifier.height(16.dp))
            SearchBar(viewModel = viewModel)
            Spacer(modifier = Modifier.height(16.dp))
            NearRestaurants()
            BlueRestaurant()
            Spacer(modifier = Modifier.height(16.dp))

            if (isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .padding(16.dp)
                        .align(Alignment.CenterHorizontally)
                )
            } else {
                CocktailList(cocktailList = cocktailList, onCocktailClick = { selectedCocktail ->
                    navController.navigate("details/${selectedCocktail.idDrink}")
                })
            }
        }
    }
}


@Composable
fun Header() {
    Column {
        CustomText(
            text = stringResource(R.string.let_s_eat_quality_food),
            textSize = 35.sp,
            fontWeight = FontWeight.Bold
        )
        CustomText(
            text = stringResource(R.string.quality_food),
            textSize = 35.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
