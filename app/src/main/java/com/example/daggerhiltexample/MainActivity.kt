package com.example.daggerhiltexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import com.example.daggerhiltexample.ui.theme.DaggerHiltExampleTheme
import com.example.daggerhiltexample.ui.theme.components.LazyGridComponent
import com.example.daggerhiltexample.ui.theme.components.LoadingBar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DaggerHiltExampleTheme {
                // A surface container using the 'background' color from the theme
                val viewModel  = hiltViewModel<MyViewModel>()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                        if(viewModel.isLoading.value){
                            LoadingBar(showing = true, modifier = Modifier )
                        }
                        else{
                            LazyGridComponent()
                        }



                        Button(onClick = {
                           viewModel.getPokemonList()
                            println("Size is --> ${viewModel.listData.size}")
                          println("Click result --> ${ viewModel.listData.map { it.sprites["front_default"] }}").toString()

                        }) {
                            Text("Call api")

                        }
                    }
                }
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