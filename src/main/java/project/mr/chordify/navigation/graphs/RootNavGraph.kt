package project.mr.chordify.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import project.mr.chordify.navigation.types.CustomNavType
import project.mr.chordify.presentation.ui.song_list.HomeScreen
import project.mr.chordify.presentation.ui.song_list.SearchScreen
import project.mr.chordify.navigation.routes.Screens

// https://github.com/stevdza-san/NestedNavigationBottomBarDemo/tree/master/app/src/main/java/com/example/nestednavigationbottombardemo
@ExperimentalComposeUiApi
@Composable
fun RootNavGraph(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.SearchScreen.route ){
        composable(route = Screens.SearchScreen.route){
            SearchScreen(navController = navController, viewModel = hiltViewModel())
        }
        composable(
            route = "${Screens.HomeScreen.route}/{song}",
            arguments = listOf(
                navArgument(name = "song"){
                    type= CustomNavType()
                }
            )
        ) {
            HomeScreen(song=it.arguments?.getParcelable("song"), viewModel = hiltViewModel())
        }
    }
}