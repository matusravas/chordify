package project.mr.chordify.repository.api

import project.mr.chordify.model.api.ResponseDTO
import project.mr.chordify.model.api.Song
import project.mr.chordify.model.api.SongChords


interface RepositoryAPI
 {
    suspend fun getSongs(query: String, type: Int, sortOrder: String, page: Int): ResponseDTO<List<Song>>
    suspend fun getChords(chordsLink: String): ResponseDTO<SongChords>
}