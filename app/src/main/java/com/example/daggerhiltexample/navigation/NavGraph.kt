package com.example.daggerhiltexample.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.daggerhiltexample.ui.theme.components.DetailPage
import com.example.daggerhiltexample.ui.theme.components.LazyGridComponent
import com.example.daggerhiltexample.ui.theme.components.MainScreen


@Composable
fun NavGraph() {
    val navController = rememberNavController()
    println("log1 : Initialized $navController")
    NavHost(navController = navController, startDestination = NavModel.MainPage.route) {
        composable(route = NavModel.MainPage.route) {
            MainScreen(navController = navController)
        }
        composable(route = NavModel.DetailPage.route,
//            arguments = listOf(
//                navArgument("index"){
//                    type = NavType.IntType
//                    defaultValue = 1
//                    nullable = false
//                }
//            )

        ) {
                _ ->
               DetailPage()
//            DetailsPage(index = entry.arguments!!.getInt("index"), navController = navController, mainModel = mainModel)
        }
    }

}