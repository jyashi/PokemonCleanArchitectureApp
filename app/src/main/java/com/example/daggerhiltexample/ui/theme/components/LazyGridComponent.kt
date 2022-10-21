package com.example.daggerhiltexample.ui.theme.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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


@Composable
fun LazyGridComponent (viewModel: MyViewModel = hiltViewModel()) {
//    LazyVerticalGrid(
//        columns = GridCells.Adaptive(minSize = 128.dp)
//    ) {
//        items(photos) { photo ->
//            PhotoItem(photo)
//        }
//    }


}

@Composable
fun ImageComponent(imageUrl: String){
    AsyncImage(
        ImageRequest.Builder(LocalContext.current)
            .data(imageUrl).crossfade(true)
            .transformations(CircleCropTransformation()).build(),
        contentDescription = null,
        modifier = Modifier.padding(15.dp).fillMaxWidth()
    )
}