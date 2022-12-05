package com.example.pokemonCleanArchitectureApp.navigation

//import com.example.daggerhiltexample.ui.theme.components.AppSearchBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.pokemonCleanArchitectureApp.AppNavType
import com.example.pokemonCleanArchitectureApp.MyViewModel
import com.example.pokemonCleanArchitectureApp.ui.theme.components.DetailPage
import com.example.pokemonCleanArchitectureApp.ui.theme.components.MainScreen
import com.example.pokemonCleanArchitectureApp.ui.theme.components.SearchPage


private val _tag = "NavGraph"

@Composable
fun NavGraph(viewModel: MyViewModel,navController: NavHostController,modifier: Modifier) {
    val appNavItemState = rememberSaveable { mutableStateOf(AppNavType.HOME) }
//    val navController = rememberNavController()
    println("log1 : $_tag $viewModel")

    NavHost(navController = navController, startDestination = NavModel.MainPage.route) {
        composable(route = NavModel.MainPage.route ) {
            MainScreen(navController = navController, viewModel = viewModel, appNavItemState = appNavItemState, modifier = modifier)
        }
        composable(route = NavModel.DetailPage.route + "/{id}/{nameAnswer}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                    defaultValue = 1
                    nullable = false
                },
                navArgument("nameAnswer") {
                    type = NavType.StringType
                    defaultValue = "No Input"
                    nullable = false
                }
            )

        ) { entry ->
            DetailPage(
                id = entry.arguments!!.getInt("id"),
                nameAnswer = entry.arguments!!.getString("nameAnswer")!!,
                viewModel = viewModel,
                navController = navController,
                modifier = modifier
            )

        }
        composable(route = NavModel.SearchPage.route){

            SearchPage(modifier = modifier)
        }
    }

}