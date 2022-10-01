package project.mr.chordify.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.fragment.app.FragmentActivity
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import project.mr.chordify.R
import project.mr.chordify.navigation.graphs.RootNavGraph
import project.mr.chordify.ui.theme.ChordifyTheme


@ExperimentalComposeUiApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scaffoldState = rememberScaffoldState()
            ChordifyTheme(isLoading = false, scaffoldState = scaffoldState, darkTheme = false) {
                RootNavGraph()
            }
        }
    }
}






















