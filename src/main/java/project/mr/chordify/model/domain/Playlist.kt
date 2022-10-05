package project.mr.chordify.model.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


data class Playlist(
    val id: Long? = null,
    val name: String,
    val timestampCreated: Long
)
