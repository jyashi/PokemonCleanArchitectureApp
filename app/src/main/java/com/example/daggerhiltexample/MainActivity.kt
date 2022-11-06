package com.example.daggerhiltexample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.daggerhiltexample.navigation.NavGraph
import com.example.daggerhiltexample.navigation.NavModel
import com.example.daggerhiltexample.ui.theme.DaggerHiltExampleTheme
import com.example.daggerhiltexample.ui.theme.graySurface
import dagger.hilt.android.AndroidEntryPoint

private val _tag = "MainActivity"

enum class AppNavType {
    HOME, SEARCH
}

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: MyViewModel = hiltViewModel()
            val navController = rememberNavController()
            val modifier =

            DaggerHiltExampleTheme {

            AppBodyContent(viewModel = viewModel, navController = navController)


            }
        }
    }

//    companion object {
//        const val DARK_THEME = "darkTheme"
//        fun newIntent(context: Context, isDarkTheme: Boolean) =
//            Intent(context, MainActivity::class.java).apply {
//                putExtra(DARK_THEME, isDarkTheme)
//            }
//    }
}

@Composable
fun AppBodyContent(viewModel: MyViewModel,navController: NavHostController){
    val appNavItemState = rememberSaveable { mutableStateOf(AppNavType.HOME) }
//                NavGraph(viewModel = viewModel, navController)
    Scaffold(modifier = Modifier
        ,bottomBar = {
        AppBottomNavigation(
            appNavItemState = appNavItemState,
            navController,
            viewModel,


        )
    },
        content = { paddingValues ->
            NavGraph(
                viewModel = viewModel,
                navController = navController,
                modifier = Modifier.padding(paddingValues = paddingValues).fillMaxSize().background(brush = Brush.linearGradient(
                    listOf(Color.Gray,Color.White)
                ))
            )
//                        AppBodyContent(
//                            appNavType = appNavItemState.value,
//                            modifier = Modifier.padding(paddingValues), viewModel, navController
//                        )
        }
    )
}


@Composable
fun AppBottomNavigation(
    appNavItemState: MutableState<AppNavType>,
    navController: NavController,
    viewModel: MyViewModel,


) {
    val bottomNavBackgorund = graySurface

    BottomNavigation( backgroundColor = MaterialTheme.colors.background) {
        BottomNavigationItem(selected = appNavItemState.value == AppNavType.HOME, onClick = {
            appNavItemState.value = AppNavType.HOME
            navController.navigate(route = NavModel.MainPage.route)

        },
            icon = {
                Icon(imageVector = Icons.Outlined.Home, contentDescription = null)
            },
            label = { Text(text = "Home") }
        )
        BottomNavigationItem(selected = appNavItemState.value == AppNavType.SEARCH,
            onClick = {
                appNavItemState.value = AppNavType.SEARCH
                navController.navigate(route = NavModel.SearchPage.route)
            },
            icon = {
                Icon(imageVector = Icons.Outlined.Search, contentDescription = null)
            },
            label = { Text(text = "Home") }
        )
    }
}

//@Composable
//fun AppBodyContent(
//    appNavType: AppNavType,
//    modifier: Modifier = Modifier,
//    viewModel: MyViewModel,
//    navController: NavController
//) {
//    NavGraph(
//        viewModel = viewModel,
//
//    )
//    Crossfade(
//        targetState = appNavType,
//        modifier = modifier,
//    ) { navType ->
//        when (navType) {
//
//            AppNavType.HOME -> navController.navigate(route = NavModel.MainPage.route )
//            AppNavType.SEARCH -> Search()
//
//        }
//    }
//}


@Composable
fun Search() {
    Text("Search Screen")
}

@Preview
@Composable
fun ComposablePreview(){
    DaggerHiltExampleTheme() {
        Text("Hey there", modifier = Modifier.background(MaterialTheme.colors.background))
    }

}