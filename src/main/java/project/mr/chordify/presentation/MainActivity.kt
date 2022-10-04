package project.mr.chordify.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.ExperimentalComposeUiApi
import dagger.hilt.android.AndroidEntryPoint
import project.mr.chordify.presentation.ui.Root
import project.mr.chordify.ui.theme.ChordifyTheme


@ExperimentalComposeUiApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scaffoldState = rememberScaffoldState()
            ChordifyTheme(scaffoldState = scaffoldState, darkTheme = false) {
//                RootNavGraph()
                Root()
            }
        }
    }
}






















