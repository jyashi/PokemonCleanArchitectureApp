package com.example.daggerhiltexample.ui.theme.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.daggerhiltexample.MyViewModel

@Composable
fun LoadingBar(showing: Boolean, text: String, modifier: Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        if (showing) {
            CircularProgressIndicator(modifier = modifier)
        }

        Text(text = text, modifier = Modifier.padding(12.dp))
    }

}

