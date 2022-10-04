package project.mr.chordify.presentation.vm

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import project.mr.chordify.model.api.Song
import project.mr.chordify.presentation.vm.RestApiEvents.*
import project.mr.chordify.repository.api.RepositoryAPI
import project.mr.chordify.repository.db.RepositoryDB
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList


const val STATE_SEARCH_QUERY = "song.state.query_search"

val TAG = SongListViewModel::class.qualifiedName

@HiltViewModel
class SongListViewModel @Inject constructor(
//    private val appViewModel: AppViewModel,
    private val repositoryAPI: RepositoryAPI,
    private val repositoryDB: RepositoryDB,
//    songsDao: SongsDao,
    private val savedStateHandle: SavedStateHandle
): ViewModel(){

//    val isLoading: MutableState<Boolean> = mutableStateOf(false)
//    val repo = Repository_DB_Impl(songsDao = songsDao)
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

    fun onTriggerEvent(event: RestApiEvents) {
        try {
            viewModelScope.launch {
//                isLoading.value = true
//                appViewModel.setIsLoading(true)
//                Log.d("COMON", appViewModel.isLoading.value.toString())
                when(event){
                    is SearchSongsEvent -> {
//                        setQuery(event.query)
                        searchSongs()
                    }
                    else -> {
                        Log.d(TAG, "Event not found")
                    }
                }
//                appViewModel.setIsLoading(false)
//                isLoading.value = false
            }

        }
        catch (e: Exception){
            Log.e(TAG, "exception in onTriggerEvent")
            e.printStackTrace()
        }
    }

    private suspend fun searchSongs() {
        val result = repositoryAPI.getSongs(query.value, type.value, sortOrder.value, page.value)
        searchedSongsList.value = if (result.ok) result.data else emptyList()
//        for (song in searchedSongsList.value){
//            Log.d(TAG, "artist: ${song.artist}, song: ${song.name} votes: ${song.meta.votes}")
//        }
    }

    fun insertSongToPlaylist(song: project.mr.chordify.model.entities.Song){
        viewModelScope.launch {
            val id = repositoryDB.saveSong(song)
            Log.d("INSERT", id.toString())
            val result = repositoryDB.saveSongToPlaylist(id, 1, Date().time)
            Log.d("INSERT", result.toString())
            val result1 = repositoryDB.getLastViewedSong()
            Log.d("LAST_SAVED", result1.name)
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