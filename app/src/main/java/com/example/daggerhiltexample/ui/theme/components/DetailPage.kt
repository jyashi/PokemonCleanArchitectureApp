package com.example.daggerhiltexample.ui.theme.components

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.daggerhiltexample.MyViewModel


@Composable
fun DetailPage(viewModel: MyViewModel = hiltViewModel()){
    Text("Detail page")
    Button(onClick = { /*TODO*/ }) {
        Text("Detail page")
    }

}