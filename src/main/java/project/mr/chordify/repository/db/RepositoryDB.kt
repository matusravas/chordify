package project.mr.chordify.repository.db

import project.mr.chordify.model.entities.Playlist
import project.mr.chordify.model.entities.Song
import project.mr.chordify.model.pojo.LastViewedSong


interface RepositoryDB
 {
    suspend fun getSongsFromPlaylist(playlistId: Long): List<Song>

    suspend fun getLastViewedSong(): LastViewedSong

    suspend fun saveSong(song: Song): Long

    suspend fun savePlaylist(playlist: Playlist): Long

    suspend fun saveSongToPlaylist(songId: Long, playlistId: Long, timestamp: Long): Long

    suspend fun getAllPlaylists(): List<Playlist>

    suspend fun deleteSongById(songId: Long): Int

    suspend fun deletePlaylistById(playlistId: Long): Int
}