package com.example.daggerhiltexample.ui.theme.components

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.daggerhiltexample.MyViewModel
import com.example.daggerhiltexample.ui.theme.DaggerHiltExampleTheme
import javax.inject.Inject


class SearchPage @Inject constructor (viewModel: MyViewModel): ComponentActivity() {
    init {
        println("$viewModel")
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
setContent{
    DaggerHiltExampleTheme{
        SearchPage()
    }
}
    }

}

@Composable
fun SearchPage(){
    Text("Search Screen")
}