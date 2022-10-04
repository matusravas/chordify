package project.mr.chordify.model.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "song_playlist")
data class SongPlaylist(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    @ColumnInfo(name="playlist_id")
    val playlistId: Long,
    @ColumnInfo(name="song_id")
    val songId: Long,
    @ColumnInfo(name="timestamp_added")
    val timestampAdded: Long,
)
