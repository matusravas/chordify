package project.mr.chordify.model.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "song_playlist", indices = [Index(value = ["song_id", "playlist_id"])])
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
