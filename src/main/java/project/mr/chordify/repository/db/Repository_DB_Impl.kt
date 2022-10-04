package project.mr.chordify.repository.db


import project.mr.chordify.database.daos.SongsDao
import project.mr.chordify.model.entities.Playlist
import project.mr.chordify.model.entities.Song
import project.mr.chordify.model.pojo.LastViewedSong
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class Repository_DB_Impl
@Inject constructor(private val songsDao: SongsDao): RepositoryDB {


    override suspend fun getSongsFromPlaylist(playlistId: Long): List<Song> {
        return songsDao.getAllSongsForPlaylist(playlistId)
    }

    override suspend fun getLastViewedSong(): LastViewedSong {
        return songsDao.getLastViewedSong()
    }

    override suspend fun saveSong(song: Song): Long {
        return songsDao.insertSong(song)
    }

    override suspend fun savePlaylist(playlist: Playlist): Long {
        return songsDao.insertPlaylist(playlist)
    }

    override suspend fun saveSongToPlaylist(songId: Long, playlistId: Long, timestamp: Long): Long {
        return songsDao.insertSongToPlaylist(songId, playlistId, timestamp)
    }

    override suspend fun getAllPlaylists(): List<Playlist> {
        return songsDao.getAllPlaylists()
    }

    override suspend fun deleteSongById(songId: Long): Int {
        return songsDao.deleteSongById(songId)
    }

    override suspend fun deletePlaylistById(playlistId: Long): Int {
        return songsDao.deleteSongById(playlistId)
    }

}