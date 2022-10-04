package project.mr.chordify.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import project.mr.chordify.navigation.routes.Screens
import project.mr.chordify.presentation.ui.HomeScreen
import project.mr.chordify.presentation.ui.SearchScreen

// https://github.com/stevdza-san/NestedNavigationBottomBarDemo/tree/master/app/src/main/java/com/example/nestednavigationbottombardemo
@ExperimentalComposeUiApi
@Composable
fun RootNavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = Screens.SearchScreen.route ){
        composable(route = Screens.SearchScreen.route){
            SearchScreen(viewModel = hiltViewModel())
        }
        composable(route = Screens.HomeScreen.route) {
            HomeScreen()
        }
    }
}