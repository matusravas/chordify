package project.mr.chordify.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import project.mr.chordify.model.entities.Playlist
import project.mr.chordify.model.entities.Song
import project.mr.chordify.model.pojo.LastViewedSong

@Dao
interface SongsDao {

    @Insert
    suspend fun insertSong(song: Song): Long

    @Insert
    suspend fun insertPlaylist(playlist: Playlist): Long

    @Query("INSERT INTO song_playlist (song_id, playlist_id, timestamp_added) VALUES (:songId, :playlistId, :timestamp)")
    suspend fun insertSongToPlaylist(songId: Long, playlistId: Long, timestamp: Long): Long

//    @Query("SELECT * FROM song WHERE id IN (SELECT song_id FROM song_playlist WHERE playlist_id=:playlistId)")
//    suspend fun getAllSongsForPlaylist(playlistId: Long): List<Song>

    @Query("SELECT song.*, song_playlist.playlist_id, song_playlist.timestamp_added FROM song_playlist INNER JOIN song ON song_playlist.song_id = song.id WHERE song_playlist.playlist_id=:playlistId")
    suspend fun getAllSongsForPlaylist(playlistId: Long): List<Song>

    @Query("SELECT * FROM playlist")
    suspend fun getAllPlaylists(): List<Playlist>

    @Query("SELECT s.artist, s.name, s.timestamp_last_viewed FROM song AS s ORDER BY s.timestamp_last_viewed DESC LIMIT 1")
    suspend fun getLastViewedSong(): LastViewedSong

    @Query("DELETE FROM song WHERE id=:songId")
    suspend fun deleteSongById(songId: Long): Int

    @Query("DELETE FROM playlist WHERE id=:playlistId")
    suspend fun deletePlaylistById(playlistId: Long): Int
}