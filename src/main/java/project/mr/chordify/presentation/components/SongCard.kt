package project.mr.chordify.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import project.mr.chordify.model.Song

@Composable
fun SongCard(index: Int, song: Song, onClick: ()-> Unit) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(6.dp)
        .clickable(onClick=onClick),
        elevation = 10.dp
        ) 
    {
        Column(modifier = Modifier.padding(15.dp)) {
            Text(text = "$index artist: ${song.artist}, song: ${song.name}, votes: ${song.meta.votes}, rating: ${song.meta.votes}, hits: ${song.meta.hits}")
        }
    }
}