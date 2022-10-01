package project.mr.chordify.repository

import project.mr.chordify.api.APIService
import project.mr.chordify.model.ResponseDTO
import project.mr.chordify.model.Song
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class RepositoryImpl
@Inject constructor(private val apiService: APIService): Repository{

    init {
    }

    override suspend fun getSongs(query: String, type: Int, sortOrder: String, page: Int): ResponseDTO<List<Song>> {
        return apiService.getSearchedSongs(query, type, sortOrder, page)
    }

    override suspend fun getChords(chordsLink: String): ResponseDTO<String> {
        return apiService.getSongChords(chordsLink)
    }

}