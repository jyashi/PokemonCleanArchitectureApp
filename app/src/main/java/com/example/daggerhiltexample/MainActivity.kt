package com.example.daggerhiltexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.daggerhiltexample.navigation.NavGraph
import com.example.daggerhiltexample.ui.theme.DaggerHiltExampleTheme
import dagger.hilt.android.AndroidEntryPoint
private val _tag = "MainActivity"
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel:MyViewModel = hiltViewModel()
            DaggerHiltExampleTheme {
                NavGraph(viewModel = viewModel)
            }
        }
    }
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DaggerHiltExampleTheme {
        Greeting("Android")
    }
}