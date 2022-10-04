package project.mr.chordify.presentation.ui

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import project.mr.chordify.navigation.graphs.RootNavGraph
import project.mr.chordify.presentation.components.BottomBar
import project.mr.chordify.presentation.components.HorizontalDottedProgressBar

@ExperimentalComposeUiApi
@Composable
fun Root() {
    val navController = rememberNavController()

    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
//        if(isLoading) HorizontalDottedProgressBar()
        Scaffold(
            bottomBar = {BottomBar(navController = navController)}

        ) {
            RootNavGraph(navController = navController)
        }
    }

}