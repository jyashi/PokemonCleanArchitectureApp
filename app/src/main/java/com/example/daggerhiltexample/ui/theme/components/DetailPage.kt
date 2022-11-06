package com.example.daggerhiltexample.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
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
fun DetailPage(viewModel: MyViewModel,navController: NavController,modifier: Modifier,id:Int,nameAnswer:String) {

    val imageUrl = viewModel.listData[id].sprites["front_default"]

    Box {
        Column(modifier = modifier,
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
        AnimatedToolBar(navController)

    }
}


@Composable
fun AnimatedToolBar( navController:NavController) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        IconButton(
            content = {Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)},
onClick = {navController.popBackStack()}
        )
//        Text(
//            text = album.song,
//            color = MaterialTheme.colors.onSurface,
//            modifier = Modifier
//                .padding(16.dp)
//                .alpha(((scrollState.value + 0.001f) / 1000).coerceIn(0f, 1f))
//        )
        Icon(
            imageVector = Icons.Default.MoreVert, tint = MaterialTheme.colors.onSurface,
            contentDescription = null
        )
    }
}

@Composable
fun ProfileCard(){
Surface(modifier = Modifier.background(Color.Black)) {

    Text(text = "This is for test")
}
}