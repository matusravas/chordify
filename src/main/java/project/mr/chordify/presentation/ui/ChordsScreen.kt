package project.mr.chordify.presentation.ui.song_list

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import project.mr.chordify.presentation.vm.RestApiEvents.*
import project.mr.chordify.presentation.vm.SongViewModel

@ExperimentalComposeUiApi
@Composable
fun ChordsScreen(chordsLink: String, viewModel: SongViewModel) {

    LaunchedEffect(key1 = chordsLink){
     viewModel.onTriggerEvent(SearchChordsEvent(chordsLink))
    }

    val scroll = rememberScrollState(0)
    val song = viewModel.song.value
    val songChords = viewModel.songChords.value

    Log.d("RECOMPOSE", "CHORDS_SCREEN")
    Box(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            song?.let { Text(text = "artist: ${song.artist}, song: ${song.name} votes: ${song.meta.votes}") }
                ?: Text(text = "Not found")
            viewModel.songChords.value?.let { Text(text = it ,Modifier.verticalScroll(scroll))} ?: Text(text = "No chords found")
        }
    }

}