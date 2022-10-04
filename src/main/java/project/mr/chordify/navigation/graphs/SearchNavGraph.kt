package project.mr.chordify.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import project.mr.chordify.navigation.routes.Screens
import project.mr.chordify.presentation.ui.song_list.ChordsScreen
import project.mr.chordify.presentation.ui.song_list.NotFoundScreen

@ExperimentalComposeUiApi
@Composable
fun SearchNavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = "${Screens.ChordsScreen.route}/{chordsLink}"){
        composable(route = "${Screens.ChordsScreen.route}/{chordsLink}", arguments = listOf(
            navArgument(name = "chordsLink"){
                type = NavType.StringType
            }
        )){
            it.arguments?.getString("chordsLink")?.let { link->
                ChordsScreen(chordsLink = link, viewModel = hiltViewModel())
            }?:
            NotFoundScreen()

        }
    }
}