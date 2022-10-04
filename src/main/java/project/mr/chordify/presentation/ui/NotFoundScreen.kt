package project.mr.chordify.presentation.ui.song_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier

@ExperimentalComposeUiApi
@Composable
fun NotFoundScreen() {
    Box(modifier = Modifier.fillMaxWidth()) {
        Text(text = "Not Found")
    }
}