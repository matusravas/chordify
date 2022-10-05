package project.mr.chordify.repository

import project.mr.chordify.api.APIService
import project.mr.chordify.database.daos.Dao
import project.mr.chordify.model.api.ApiResponse
import project.mr.chordify.model.api.SongMapperApi
import project.mr.chordify.model.domain.Song
import project.mr.chordify.model.domain.Playlist
import project.mr.chordify.model.domain.pojo.LastViewedSong
import project.mr.chordify.model.entities.PlaylistMapperDb
import project.mr.chordify.model.entities.SongMapperDb
import javax.inject.Inject


class Repository_Impl @Inject constructor(
    private val apiService: APIService,
    private val dao: Dao,
    private val songMapperApi: SongMapperApi,
    private val songMapperDb: SongMapperDb,
    private val playlistMapperDb: PlaylistMapperDb
    ): Repository{

    override suspend fun fetchSongs(
        query: String,
        type: Int,
        sortOrder: String,
        page: Int
    ): ApiResponse<List<Song>> {
        val responseDto = apiService.getSearchedSongs(query, type, sortOrder, page)
        return ApiResponse(
            ok = responseDto.ok,
            data= songMapperApi.toDomainList(responseDto.data),
            isError = responseDto.isError,
            errorMessage = responseDto.errorMessage)
    }

//    override suspend fun fetchChords(chordsLink: String): ApiResponse<SongChordsDto> {
//        return apiService.getSongChords(chordsLink)
//    }

    override suspend fun getSongsFromPlaylist(playlistId: Long): List<Song> {
        return songMapperDb.toDomainList(dao.getAllSongsForPlaylist(playlistId))
    }

    override suspend fun getLastViewedSong(): LastViewedSong {
        return dao.getLastViewedSong()
    }

//    override suspend fun checkIfSongInPlaylistBySongIds(songIds: List<Long>, playlistId: Long): List<Int> {
//        return dao.checkIfListOfSongsIsInPlaylistBySongIds(songIds, playlistId)
//    }

    override suspend fun checkIfSongInPlaylistByChordsLinks(chordsLinks: List<String>, playlistId: Long): List<Song> {
        return songMapperDb.toDomainList(dao.checkIfListOfSongsIsInPlaylistByChordsLink(chordsLinks, playlistId))
    }

    override suspend fun saveSong(song: Song): Long {
        return dao.insertSong(songMapperDb.mapFromDomainModel(song))
    }

    override suspend fun savePlaylist(playlist: Playlist): Long {
        return dao.insertPlaylist(playlistMapperDb.mapFromDomainModel(playlist))
    }

    override suspend fun saveSongToPlaylist(songId: Long, playlistId: Long, timestamp: Long): Long {
        return dao.insertSongToPlaylist(songId, playlistId, timestamp)
    }

    override suspend fun getAllPlaylists(): List<Playlist> {
        return playlistMapperDb.toDomainList(dao.getAllPlaylists())
    }

    override suspend fun deleteSongById(songId: Long): Int {
        return dao.deleteSongById(songId)
    }

    override suspend fun deletePlaylistById(playlistId: Long): Int {
        return dao.deleteSongById(playlistId)
    }

}