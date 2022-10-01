package project.mr.chordify.repository

import project.mr.chordify.model.ResponseDTO
import project.mr.chordify.model.Song


interface Repository
 {
    suspend fun getSongs(query: String, type: Int, sortOrder: String, page: Int): ResponseDTO<List<Song>>
    suspend fun getChords(chordsLink: String): ResponseDTO<String>
}