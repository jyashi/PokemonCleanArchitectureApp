package com.example.daggerhiltexample.ui.theme.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.example.daggerhiltexample.MyViewModel

@Composable
fun LazyGridComponent(viewModel: MyViewModel, imageList: List<String>, imageUrl: String) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp)
    ) {
        items(photos) { photo ->
            PhotoItem(photo)
        }
    }

}

@Composable
fun ImageComponent(imageUrl: String){
    AsyncImage(
        ImageRequest.Builder(LocalContext.current)
            .data(imageUrl).crossfade(true)
            .transformations(CircleCropTransformation()).build(),
        contentDescription = null,
        modifier = Modifier.padding(15.dp)
    )
}