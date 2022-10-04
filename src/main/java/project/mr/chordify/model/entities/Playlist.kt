package project.mr.chordify.model.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "playlist")
data class Playlist(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    @ColumnInfo(name="name")
    val name: String,
    @ColumnInfo(name="timestamp_created")
    val timestampCreated: Long,
)
