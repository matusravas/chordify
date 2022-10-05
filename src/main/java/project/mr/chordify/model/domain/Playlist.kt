package project.mr.chordify.model.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Song(
    val artist: String,
    val name: String,
    val fullUrl: String,
    val chordsLink: String,
    val isFavorite: Boolean = false,
    val isInPlaylist: Boolean = false,
    val meta: SongMetadata
): Parcelable
