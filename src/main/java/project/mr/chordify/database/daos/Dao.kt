package project.mr.chordify.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import project.mr.chordify.model.entities.Playlist
import project.mr.chordify.model.entities.Song
import project.mr.chordify.model.domain.pojo.LastViewedSong

@Dao
interface Dao {

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

    @Query("SELECT song.*, song_playlist.playlist_id, song_playlist.timestamp_added FROM song_playlist INNER JOIN song ON song_playlist.song_id = song.id WHERE song_playlist.playlist_id=:playlistId")
    suspend fun getAllFavouritesSongs(playlistId: Long): List<Song>

//    @Query("SELECT s.* FROM song as s INNER JOIN song_playlist as sp ON sp.song_id = s.id WHERE s.id IN (:songIds) AND sp.playlist_id = :playlistId")
//    @Query("SELECT CASE WHEN EXISTS (SELECT * FROM song_playlist WHERE playlist_id = :playlistId AND song_id IN (SELECT id FROM song as s WHERE chords_link IN (:songIds) ) THEN 1 ELSE 0 END")
//    suspend fun checkIfListOfSongsIsInPlaylistBySongIds(songIds: List<Long>, playlistId: Long): List<Int>
//    suspend fun checkIfListOfSongsIsInPlaylistBySongIds(songIds: List<Long>, playlistId: Long): List<Song>

    @Query("SELECT s.* FROM song as s INNER JOIN song_playlist as sp ON sp.song_id = s.id WHERE s.chords_link IN (:chordsLinks) AND sp.playlist_id = :playlistId")
//    @Query("SELECT CASE WHEN EXISTS (SELECT * FROM song_playlist WHERE  = ) THEN CAST(1 AS BIT) ELSE CAST(0 AS BIT) END")
//    @Query("SELECT CASE WHEN EXISTS (SELECT * FROM song_playlist WHERE playlist_id = :playlistId AND song_id IN (SELECT id FROM song WHERE chords_link IN (:chordsLinks) )) THEN 1 ELSE 0 END")
    suspend fun checkIfListOfSongsIsInPlaylistByChordsLink(chordsLinks: List<String>, playlistId: Long): List<Song>

    @Query("SELECT * FROM playlist")
    suspend fun getAllPlaylists(): List<Playlist>

    @Query("SELECT s.artist, s.name, s.timestamp_last_viewed FROM song AS s ORDER BY s.timestamp_last_viewed DESC LIMIT 1")
    suspend fun getLastViewedSong(): LastViewedSong

    @Query("DELETE FROM song WHERE id=:songId")
    suspend fun deleteSongById(songId: Long): Int

    @Query("DELETE FROM playlist WHERE id=:playlistId")
    suspend fun deletePlaylistById(playlistId: Long): Int
}