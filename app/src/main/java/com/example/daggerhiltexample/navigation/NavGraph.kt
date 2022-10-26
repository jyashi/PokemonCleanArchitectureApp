package com.example.daggerhiltexample.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.daggerhiltexample.ui.theme.components.DetailPage
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

        ) {
                DetailPage()

        }
    }

}