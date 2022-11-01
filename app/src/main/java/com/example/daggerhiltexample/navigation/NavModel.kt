package com.example.daggerhiltexample.navigation

sealed class NavModel(val route: String) {
    object MainPage: NavModel(route = "main_page")
    object DetailPage: NavModel(route = "detail_page")

    fun passId(id:Int):Int{
        return id
    }
    fun nameAns(name:String):String{
        return name
    }
}