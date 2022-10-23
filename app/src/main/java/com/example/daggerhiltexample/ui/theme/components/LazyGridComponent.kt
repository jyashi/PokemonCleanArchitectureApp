package com.example.daggerhiltexample.ui.theme.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
        println("Grid page model --> $viewModel")
    }
}


//@Composable
//fun LazyGridComponent (viewModel: MyViewModel = hiltViewModel(),id: Int) {
//    LazyVerticalGrid(
//        columns = GridCells.Adaptive(minSize = 128.dp)
//    ) {
//        items(5) { photo ->
//            PhotoItem(ImageComponent(id))
//        }
//    }
//    Text("View model address --> $viewModel")
//
//}

//@Composable
//fun ImageComponent(id: Int): Int {
//    AsyncImage(
//        ImageRequest.Builder(LocalContext.current)
//            .data(imageUrl).crossfade(true)
//            .transformations(CircleCropTransformation()).build(),
//        contentDescription = null,
//        modifier = Modifier.padding(15.dp)
//    )
//}

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