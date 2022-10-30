package com.example.daggerhiltexample.ui.theme.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.example.daggerhiltexample.MyViewModel
import com.example.daggerhiltexample.navigation.NavModel


@Composable
fun MainScreen(viewModel: MyViewModel = hiltViewModel(), navController: NavController){

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
            if(viewModel.isLoading.value){
                LoadingBar(showing = true,text = "Fetching data...", modifier = Modifier )
            }
            else {
                LazyGridComponent(navController = navController)
            }

        }
    }

}

@Composable
fun LazyGridComponent ( viewModel: MyViewModel = hiltViewModel(),navController: NavController) {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 120.dp), modifier = Modifier.fillMaxWidth()
        ) {
            items(viewModel.listData.size) { id ->
                ImageComponent(id = id, viewModel = viewModel, navController)
            }
        }




}

@Composable
fun ImageComponent(id: Int, viewModel: MyViewModel, navController: NavController) {
    val imageUrl = viewModel.listData[id].sprites["front_default"]
    val showDialog = remember {mutableStateOf(false)}
    Box(modifier = Modifier
        .size(100.dp)
        .fillMaxSize()){
        AsyncImage(
            ImageRequest.Builder(LocalContext.current)
                .data(imageUrl).crossfade(true)
                .transformations(CircleCropTransformation()).build(),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(100.dp)
                .fillMaxSize()
                .border(
                    BorderStroke(1.dp, Color.Gray)
                )
                .clip(RectangleShape)

        )
        TextButton(modifier = Modifier
            .size(100.dp)
            .fillMaxSize() ,onClick = { showDialog.value = true  }) {
            Text("")

        }
        MyAlertDialog(showDialog = showDialog,navController)

    }

}

@Composable
fun MyAlertDialog(showDialog: MutableState<Boolean>, navController: NavController){

   if(showDialog.value){
       AlertDialog(
           onDismissRequest = { showDialog.value = false },
           title = { Text("Test your Pokemon knowledge") },
           text = {
               Column {
                   Text("Name of Pokemon?")
                   MyTextField()

               }
           },
          
               
           
           buttons = {
               TextButton(content = { Text(text = "Submit")} ,onClick = {showDialog.value = false})
               TextButton(onClick = {navController.navigate(route = NavModel.DetailPage.route)}) {
                   Text(text = "View Pokemon Card")
               }      
                     },
       )
   }

}

@Composable
fun MyTextField(){
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Enter Name") }
    )
}