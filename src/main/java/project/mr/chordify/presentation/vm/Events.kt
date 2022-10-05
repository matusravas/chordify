package project.mr.chordify.presentation.vm

sealed class RestApiEvents {
    object SearchSongsEvent : RestApiEvents()
//    data class NewSongsSearchEvent(val query: String) : SongEvent()
    data class SearchChordsEvent(val chordsLink: String): RestApiEvents()
}