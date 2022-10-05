package project.mr.chordify.repository

import project.mr.chordify.model.api.ApiResponse
import project.mr.chordify.model.domain.Song
import project.mr.chordify.model.domain.Playlist
import project.mr.chordify.model.domain.pojo.LastViewedSong

interface Repository {
    // API
    suspend fun fetchSongs(query: String, type: Int, sortOrder: String, page: Int): ApiResponse<List<Song>>
//    suspend fun fetchChords(chordsLink: String): ApiResponse<SongChordsDto>
    //DB
    suspend fun getAllPlaylists(): List<Playlist>
    suspend fun getSongsFromPlaylist(playlistId: Long): List<Song>
    suspend fun getLastViewedSong(): LastViewedSong
//    suspend fun checkIfSongInPlaylistBySongIds(songIds: List<Long>, playlistId: Long): List<Int>
    suspend fun checkIfSongInPlaylistByChordsLinks(chordsLinks: List<String>, playlistId: Long): List<Song>
    suspend fun saveSong(song: Song): Long
    suspend fun savePlaylist(playlist: Playlist): Long
    suspend fun saveSongToPlaylist(songId: Long, playlistId: Long, timestamp: Long): Long
    suspend fun deleteSongById(songId: Long): Int
    suspend fun deletePlaylistById(playlistId: Long): Int
}