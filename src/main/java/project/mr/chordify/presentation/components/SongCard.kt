package project.mr.chordify.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import project.mr.chordify.model.domain.Song

@Composable
fun SongCard(index: Int, song: Song, onSongCardClick: ()-> Unit, onAddToFavoritesClick: ()-> Unit) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(4.dp)
        .clickable(onClick = onSongCardClick),
        elevation = 6.dp,
        )
    {
        Row(modifier = Modifier.padding(20.dp).fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
            Column(Modifier.weight(4f)) {
                Text(
                    modifier = Modifier.padding(bottom = 4.dp),
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = MaterialTheme.colors.secondary)) {
                            append("$index. ")
                        }
                        append("${song.artist} - ${song.name}")
                    }
                )

                Text(
                    style = MaterialTheme.typography.body2,
                    text = "votes: ${song.meta.votes} | rating: ${song.meta.rating}")
//                Icon(Icons.Outlined.Favorite,null)
            }
            Column(Modifier.weight(1f), horizontalAlignment = Alignment.End) {
                Icon(
                    imageVector = if(song.isFavorite) Icons.Outlined.Favorite else Icons.Outlined.FavoriteBorder,
                        "Add to favorites",
                    tint = MaterialTheme.colors.secondary,
                    modifier = Modifier.clickable { onAddToFavoritesClick() } )
            }

        }

    }
}