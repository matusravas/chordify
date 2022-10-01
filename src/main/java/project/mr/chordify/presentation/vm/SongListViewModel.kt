package project.mr.chordify.presentation.vm

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import project.mr.chordify.model.APIResponse
import project.mr.chordify.model.Song
import project.mr.chordify.presentation.vm.SongEvent.*
import project.mr.chordify.repository.Repository
import javax.inject.Inject


const val STATE_SEARCH_QUERY = "song.state.query_search"

val TAG = SongListViewModel::class.qualifiedName

@HiltViewModel
class SongListViewModel @Inject constructor(
    private val repository: Repository,
    private val savedStateHandle: SavedStateHandle
): ViewModel(){

    val isLoading: MutableState<Boolean> = mutableStateOf(false)

    val query: MutableState<String> = mutableStateOf("")
    val type: MutableState<Int> = mutableStateOf(300)
    val sortOrder: MutableState<String> = mutableStateOf("desc")
    val page: MutableState<Int> = mutableStateOf(1)
    val searchedSongsList: MutableState<List<Song>> = mutableStateOf(ArrayList())

    init {
//        savedStateHandle.get<String>(STATE_SEARCH_QUERY)?.let {
//            setSearchQuery(it)
//        }
    }

    fun onTriggerEvent(event: SongEvent) {
        try {
            viewModelScope.launch {
                isLoading.value = true
                when(event){
                    is NewSongsSearchEvent -> {
//                        setQuery(event.query)
                        searchSongs()
                    }
                    else -> {
                        Log.d(TAG, "Event not found")
                    }
                }
                isLoading.value = false
            }

        }
        catch (e: Exception){
            Log.e(TAG, "exception in onTriggerEvent")
            e.printStackTrace()
        }
    }

    private suspend fun searchSongs() {
        val result = repository.getSongs(query.value, type.value, sortOrder.value, page.value)
        searchedSongsList.value = if (result.ok) result.data else emptyList()
        for (song in searchedSongsList.value){
            Log.d(TAG, "artist: ${song.artist}, song: ${song.name} votes: ${song.meta.votes}")
        }
    }

    fun handleQueryChanged(query: String) {
        setQuery(query)
    }

    private fun setQuery(query: String) {
        this.query.value = query
        Log.d("CHANGE", query)
        savedStateHandle[STATE_SEARCH_QUERY] = query
    }
}