package project.mr.chordify.repository.api

import project.mr.chordify.api.APIService
import project.mr.chordify.model.api.ResponseDTO
import project.mr.chordify.model.api.Song
import project.mr.chordify.model.api.SongChords
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class RepositoryAPI_Impl
@Inject constructor(private val apiService: APIService): RepositoryAPI {

    override suspend fun getSongs(query: String, type: Int, sortOrder: String, page: Int): ResponseDTO<List<Song>> {
        return apiService.getSearchedSongs(query, type, sortOrder, page)
    }

    override suspend fun getChords(chordsLink: String): ResponseDTO<SongChords> {
        return apiService.getSongChords(chordsLink)
    }

}