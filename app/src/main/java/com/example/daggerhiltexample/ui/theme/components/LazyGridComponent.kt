package com.example.daggerhiltexample.ui.theme.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.example.daggerhiltexample.MyViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


class GirdPage @Inject constructor(viewModel: HiltViewModel) {
    init {
//        println("Grid page model --> $viewModel")
    }
}


@Composable
fun LazyGridComponent ( viewModel: MyViewModel = hiltViewModel()) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 100.dp), modifier = Modifier.fillMaxWidth()
    ) {
        items(viewModel.listData.size) { id ->
            ImageComponent(id = id, viewModel = viewModel)




        }
    }


}

@Composable
fun ImageComponent(id: Int, viewModel: MyViewModel) {
    val imageUrl = viewModel.listData[id].sprites["front_default"]
    AsyncImage(
        ImageRequest.Builder(LocalContext.current)
            .data(imageUrl).crossfade(true)
            .transformations(CircleCropTransformation()).build(),
        contentDescription = null,
        contentScale = ContentScale.Fit,
        modifier = Modifier.padding(15.dp).size(100.dp).fillMaxSize().border(
            BorderStroke(1.dp, Color.Gray),
            CircleShape
        ).clip(CircleShape)

    )
}

@Composable
fun LoadingBar(showing: Boolean, modifier: Modifier) {
    if (showing) {
        CircularProgressIndicator(modifier = modifier)
    }
}

//@Composable
//fun PhotoGrid(photos: List<Photo>) {
//    LazyVerticalGrid(
//        columns = GridCells.Adaptive(minSize = 128.dp)
//    ) {
//        items(photos) { photo ->
//            PhotoItem(photo)
//        }
//    }
//}

/*
TODO
1. View model provides data for a single character
2. Call request needs to be made for each id
3. View model exposes getpokemon with id parameter.
4. So need a for loop that takes the ID parameter and then does Call
5. Result gets saved to List<ApiDetail>
6. Need to implement loop method inside view model
7. Add the 
* */