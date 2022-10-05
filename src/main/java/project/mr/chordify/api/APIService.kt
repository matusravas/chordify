package project.mr.chordify.api

import project.mr.chordify.model.api.ApiResponse
import project.mr.chordify.model.api.SongDto
import project.mr.chordify.model.api.SongChordsDto
import retrofit2.http.GET
import retrofit2.http.Query


interface APIService {

    @GET("songs")
    suspend fun getSearchedSongs(@Query("query") query: String, @Query("type") type: Int, @Query("sortOrder") sortOrder: String, @Query("page") page: Int): ApiResponse<List<SongDto>>

    @GET("chords")
    suspend fun getSongChords(@Query("tab") chordsLink: String): ApiResponse<SongChordsDto>
}