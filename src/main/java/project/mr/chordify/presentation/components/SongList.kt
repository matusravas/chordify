package project.mr.chordify.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import project.mr.chordify.model.Song


@Composable
fun SongList(
//    isLoading: Boolean,
    songs: List<Song>,
//    onItemClick: (event: String) -> Unit
    onItemClick: (song: Song) -> Unit
) {
    Box(modifier = Modifier.background(MaterialTheme.colors.surface)){
//        if(isLoading && songs.isEmpty()){
//            HorizontalDottedProgressBar()
//        }
//        else if(songs.isEmpty()){
////            Todo show SnackBar
//        }
        if(songs.isEmpty()){
//            Todo show SnackBar
        }
        else {
            LazyColumn {
                itemsIndexed(songs){ index, song->
                    SongCard(index+1, song, onClick = {onItemClick(song)})
                }
            }
        }
    }

}