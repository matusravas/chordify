package project.mr.chordify.model.api

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class SongMetadataDto(
    @SerializedName("votes")
    val votes: Int,
    @SerializedName("rating")
    val rating: Float,
    @SerializedName("score")
    val score: Float,
    @SerializedName("hits")
    val hits: Int? = null
): Parcelable