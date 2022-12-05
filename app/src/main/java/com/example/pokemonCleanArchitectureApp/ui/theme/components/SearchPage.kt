package com.example.pokemonCleanArchitectureApp.ui.theme.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun SearchPage(modifier: Modifier) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Page in progress")
        }
        AppSearchBar { onClickAction() }
    }
}


@Composable
fun AppSearchBar(onClickAction: ()->Unit) {
    TopAppBar(modifier = Modifier.padding(15.dp), title = {
        Text("Search here")
    }, actions = {
        IconButton(onClick = {
onClickAction()
        }) {
            Icon(imageVector = Icons.Filled.Search, contentDescription = null)
        }
    })

}


fun onClickAction():Unit {
    println("Hello")
}