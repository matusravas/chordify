package project.mr.chordify.presentation.vm

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import okhttp3.internal.notify
import project.mr.chordify.model.domain.Song
import project.mr.chordify.presentation.vm.RestApiEvents.*
import project.mr.chordify.presentation.vm.DatabaseEvents.*
import project.mr.chordify.repository.Repository
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList


const val STATE_SEARCH_QUERY = "song.state.query_search"

val TAG = SongListSearchViewModel::class.qualifiedName

@HiltViewModel
class SongListSearchViewModel @Inject constructor(
//    private val appViewModel: AppViewModel,
    private val repository: Repository,
    private val savedStateHandle: SavedStateHandle
): ViewModel(){

//    val isLoading: MutableState<Boolean> = mutableStateOf(false)
//    val repo = Repository_DB_Impl(songsDao = songsDao)
    private var _query: MutableState<String> = mutableStateOf("")
    val query: State<String> = _query

    private var _searchedSongsList: MutableState<List<Song>> = mutableStateOf(ArrayList())
    val searchedSongsList: State<List<Song>> = _searchedSongsList

    private var _type: MutableState<Int> = mutableStateOf(300)
    val type: State<Int> = _type
    private var _sortOrder: MutableState<String> = mutableStateOf("desc")
    val sortOrder: State<String> = _sortOrder
    private var _page: MutableState<Int> = mutableStateOf(1)
    val page: State<Int> = _page

    private var _isLoading: MutableState<Boolean> = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading
//    val favoritesSongsList: MutableState<List<Boolean>> = mutableStateOf(ArrayList())

    init {
//        savedStateHandle.get<String>(STATE_SEARCH_QUERY)?.let {
//            setSearchQuery(it)
//        }
    }

    fun onTriggerApiEvent(event: RestApiEvents) {
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
            Log.e(TAG, "exception in onTriggerApiEvent")
            e.printStackTrace()
        }
    }

    fun onTriggerDbEvent(event: DatabaseEvents){
        try {
            _isLoading.value = true
            viewModelScope.launch {
                when(event){
                    is GetAllPlaylistsEvent -> {
                        searchSongs()
                    }
                    is GetAllSongsFromPlaylistEvent -> {

                    }
                    is GetAllSavedSongsEvent -> {

                    }
                    is AddSongToPlaylistEvent -> {
                        // Todo save it simultaneously to Song & SongPlaylist table
                        addSongToPlaylist(event.song, event.playlistId)
                    }
                }
            }
            _isLoading.value = false

        }
        catch (e: Exception){
            Log.e(TAG, "exception in onTriggerDbEvent")
            e.printStackTrace()
        }
//        viewModelScope.launch {
//            val id = repository.saveSong(song)
//            Log.d("INSERT", id.toString())
//            val result = repository.saveSongToPlaylist(id, 1, Date().time)
//            Log.d("INSERT", result.toString())
//            val result1 = repository.getLastViewedSong()
//            Log.d("LAST_SAVED", result1.name)
//        }
    }


    private suspend fun searchSongs() {
        Log.d("QUERY", query.value)
        val result = repository.fetchSongs(query.value, type.value, sortOrder.value, page.value)
        if (result.ok) {
            val favoritesSongList = result.data.map { it.chordsLink}.toList().let {
                repository.checkIfSongInPlaylistByChordsLinks(it, 1)
            }

            for(song in result.data){
                for(favSong in favoritesSongList){
                    if(song.chordsLink == favSong.chordsLink){
                        song.isFavorite = true
                        break
                    }
                }
            }
            _searchedSongsList.value = result.data
        }
    }

    private suspend fun addSongToPlaylist(song: Song, playlistId: Long) {

        val songId = repository.saveSong(song)
        val songPlaylistId = songId.let { repository.saveSongToPlaylist(it, playlistId, Date().time)  }
        val idx = _searchedSongsList.value.indexOf(song)
        var i = 0
//        for(s: Song in _searchedSongsList.value){
//            if(i == idx) s.isFavorite = true else i++
//        }
//        val obj = searchedSongsList.value[idx]
        _searchedSongsList.value = _searchedSongsList.value.map { s: Song ->
            if(s == song) {
                s.also { it.isFavorite = true }
//                s = s.copy(isFavorite = true)
                Log.d("FOUND", song.name)}
            s
        }
//        _searchedSongsList.value[idx] = _searchedSongsList.value[idx].copy(isFavorite = true)
//        searchedSongsList.value = searchedSongsList.value.find(song).let {  }
//        searchedSongsList.value = searchedSongsList.value.map {  }
//        Log.d("IDX", idx.toString())
    }


//    private fun findFavouritesSongs() {
//
//    }

    fun handleQueryChanged(query: String) {
        setQuery(query)
    }

    private fun setQuery(query: String) {
        this._query.value = query
        savedStateHandle[STATE_SEARCH_QUERY] = query
    }
}