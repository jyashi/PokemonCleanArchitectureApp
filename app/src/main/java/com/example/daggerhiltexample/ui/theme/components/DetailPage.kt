package com.example.daggerhiltexample.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.example.daggerhiltexample.MyViewModel

private val _tag = "Detail Page"

@Composable
fun DetailPage(viewModel: MyViewModel,navController: NavController,id:Int,nameAnswer:String) {

    val imageUrl = viewModel.listData[id].sprites["front_default"]

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            AsyncImage(
                ImageRequest.Builder(LocalContext.current)
                    .data(imageUrl).crossfade(true)
                    .transformations(CircleCropTransformation()).build(),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(100.dp)
                    .fillMaxSize()
                    .clip(RectangleShape)

            )
            Text(viewModel.listData[id].name)
            Text("Your answer : $nameAnswer")
            Text("App in progress. Check back later")
        }

    }
}

@Composable
fun ProfileCard(){
Surface(modifier = Modifier.background(Color.Black)) {

    Text(text = "This is for test")
}
}