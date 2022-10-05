package project.mr.chordify.presentation.vm

import project.mr.chordify.model.domain.Song

sealed class RestApiEvents {
    object SearchSongsEvent: RestApiEvents()
    data class SearchChordsEvent(val chordsLink: String): RestApiEvents()
}


sealed class DatabaseEvents {
    object GetAllPlaylistsEvent: DatabaseEvents()
    data class GetAllSongsFromPlaylistEvent(val playlistId: Long): DatabaseEvents()
    object GetAllSavedSongsEvent: DatabaseEvents()
    data class AddSongToPlaylistEvent(val song: Song, val playlistId: Long): DatabaseEvents()
}