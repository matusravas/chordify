package project.mr.chordify.model.api

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class Song(
    @SerializedName("artist")
    val artist: String,
    @SerializedName("song")
    val name: String,
    @SerializedName("full_url")
    val fullUrl: String,
    @SerializedName("chords_link")
    val chordsLink: String,
    @SerializedName("meta")
    val meta: Meta

): Parcelable
