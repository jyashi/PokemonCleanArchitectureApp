package com.example.daggerhiltexample.ui.theme.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.daggerhiltexample.MyViewModel


@Composable
fun DetailPage(viewModel: MyViewModel = hiltViewModel(),modifier: Modifier = Modifier) {
//    Column(
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
        Text("App in progress. Check back later", modifier = Modifier)
//    }



}