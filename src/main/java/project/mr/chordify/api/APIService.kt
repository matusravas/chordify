package project.mr.chordify.api

import project.mr.chordify.model.ResponseDTO
import project.mr.chordify.model.Song
import retrofit2.http.GET
import retrofit2.http.Query


interface APIService {

    @GET("/songs")
    suspend fun getSearchedSongs(@Query("query") query: String, @Query("type") type: Int, @Query("sortOrder") sortOrder: String, @Query("page") page: Int): ResponseDTO<List<Song>>

    @GET("/chords")
    suspend fun getSongChords(@Query("tab") chordsLink: String): ResponseDTO<String>
}