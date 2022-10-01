package project.mr.chordify.presentation.vm

import project.mr.chordify.model.Song

sealed class SongEvent {
    object NewSongsSearchEvent : SongEvent()
//    data class NewSongsSearchEvent(val query: String) : SongEvent()
    data class NewSongChordsSearchEvent(val song: Song): SongEvent()
}