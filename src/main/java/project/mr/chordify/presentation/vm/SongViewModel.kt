package project.mr.chordify.presentation.vm

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import project.mr.chordify.model.Song
import project.mr.chordify.presentation.vm.SongEvent.*
import project.mr.chordify.repository.Repository
import javax.inject.Inject


@HiltViewModel
class SongViewModel @Inject constructor(
    private val repository: Repository,
    private val savedStateHandle: SavedStateHandle
): ViewModel(){

    val isLoading: MutableState<Boolean> = mutableStateOf(false)

    val song: MutableState<Song?> = mutableStateOf(null)
    val songChords: MutableState<String?> = mutableStateOf(null)

    init {
//        savedStateHandle.get<String>(STATE_SEARCH_QUERY)?.let {
//            setSearchQuery(it)
//        }
    }

    fun onTriggerEvent(event: SongEvent) {
        try {
            viewModelScope.launch {
                isLoading.value = true
                when(event) {
                    is NewSongChordsSearchEvent -> {
                        song.value = event.song
                        searchSongChords(event.song.chordsLink)
                    }
                    else -> {
                        Log.d(TAG, "Event not found")
                    }
                }
                isLoading.value = false
            }
        }
        catch (e: Exception){
            e.printStackTrace()
        }
    }

    private suspend fun searchSongChords(chordsLink: String) {
        val result = repository.getChords(chordsLink)
        songChords.value = result.data
    }
}