package com.example.daggerhiltexample.navigation



sealed class NavModel(val route: String) {
    object MainPage: NavModel(route = "main_page")
    object DetailPage: NavModel(route = "detail_page")
    object SearchPage: NavModel(route = "search_page")

    fun PageArgs(vararg args: String):String{
        return buildString {
            append(route)
            args.forEach {

                append("/$it")
            }
        }
    }
}