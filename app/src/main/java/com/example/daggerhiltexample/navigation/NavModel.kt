package com.example.daggerhiltexample.navigation

sealed class NavModel(val route: String) {
    object MainPage: NavModel(route = "main_page")
    object DetailPage: NavModel(route = "detail_page")
}