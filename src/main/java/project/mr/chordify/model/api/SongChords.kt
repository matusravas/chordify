package project.mr.chordify.model.api

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SongChords(
    val chords: String,
    val song: Song
): Parcelable