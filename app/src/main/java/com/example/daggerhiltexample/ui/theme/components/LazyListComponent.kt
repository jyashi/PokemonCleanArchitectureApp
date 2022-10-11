package com.example.daggerhiltexample.ui.theme.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.daggerhiltexample.MyViewModel
import javax.inject.Inject

@Composable
fun LazyListComponent(viewModel: MyViewModel) {
    Text(text = viewModel.data.value.name)

}