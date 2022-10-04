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

@Parcelize
data class Meta(
    @SerializedName("votes")
    val votes: Int,
    @SerializedName("rating")
    val rating: Float,
    @SerializedName("score")
    val score: Float,
    @SerializedName("hits")
    val hits: Int? = null
): Parcelable
