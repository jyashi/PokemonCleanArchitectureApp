package com.example.daggerhiltexample.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.daggerhiltexample.MyViewModel
import com.example.daggerhiltexample.ui.theme.components.DetailPage
import com.example.daggerhiltexample.ui.theme.components.MainScreen

private val _tag = "NavGraph"

@Composable
fun NavGraph(viewModel: MyViewModel) {
    val navController = rememberNavController()
    println("log1 : $_tag $viewModel")

    NavHost(navController = navController, startDestination = NavModel.MainPage.route) {
        composable(route = NavModel.MainPage.route ) {
            MainScreen(navController = navController, viewModel = viewModel)
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
                navController = navController
            )

        }
    }

}