package project.mr.chordify.model.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "song")
data class Song(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    @ColumnInfo(name="artist")
    val artist: String,
    @ColumnInfo(name="name")
    val name: String,
    @ColumnInfo(name="full_url")
    val fullUrl: String,
    @ColumnInfo(name="chords_link")
    val chordsLink: String,
    @ColumnInfo(name="votes")
    val votes: Int,
    @ColumnInfo(name="rating")
    val rating: Float,
    @ColumnInfo(name="score")
    val score: Float = votes * rating,
    @ColumnInfo(name="timestamp_last_viewed")
    val lastViewedTimestamp: Long? = null
)
