package project.mr.chordify.presentation.vm

import project.mr.chordify.model.Song

sealed class RestApiEvents {
    object SearchSongsEvent : RestApiEvents()
//    data class NewSongsSearchEvent(val query: String) : SongEvent()
    data class SearchChordsEvent(val song: Song): RestApiEvents()
}