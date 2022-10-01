package project.mr.chordify.presentation.ui.song_list

import android.os.Bundle
import android.util.Log
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import project.mr.chordify.model.Meta
import project.mr.chordify.model.Song
import project.mr.chordify.presentation.vm.RestApiEvents.*
import project.mr.chordify.presentation.vm.SongListViewModel
import project.mr.chordify.presentation.vm.SongViewModel

@ExperimentalComposeUiApi
@Composable
fun HomeScreen(song: Song?, viewModel: SongViewModel) {
    song?.let{ song ->
        LaunchedEffect(key1 = song){
         viewModel.onTriggerEvent(SearchChordsEvent(song))
        }
    }
    val scroll = rememberScrollState(0)

    Log.d("RECOMPOSE", "HOME_SCREEN")
    Box(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            song?.let { Text(text = "artist: ${song.artist}, song: ${song.name} votes: ${song.meta.votes}") }
                ?: Text(text = "Not found")
            viewModel.songChords.value?.let { Text(text = it ,Modifier.verticalScroll(scroll))} ?: Text(text = "No chords found")
        }
    }

}