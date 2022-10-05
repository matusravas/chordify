package project.mr.chordify.model.api

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SongChordsDto(
    val chords: String,
    val song: SongDto
): Parcelable