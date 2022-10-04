package project.mr.chordify.presentation.ui

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import project.mr.chordify.model.entities.Song
import project.mr.chordify.presentation.components.SearchBar
import project.mr.chordify.presentation.components.SongList
import project.mr.chordify.presentation.vm.RestApiEvents.*
import project.mr.chordify.presentation.vm.SongListViewModel

@ExperimentalComposeUiApi
@Composable
fun SearchScreen(viewModel: SongListViewModel) {
//    Todo create own navController and use ne navHost setup
    val handler = remember {Handler(Looper.getMainLooper())}
    LaunchedEffect(viewModel){
        Log.d("LAUNCHED", "COROUTINE")
        viewModel.onTriggerEvent(SearchSongsEvent)
    }
//    Log.d("COMPOSABLE", "HERE")
    Log.d("RECOMPOSE", "SEARCH_SCREEN")
    val songs = viewModel.searchedSongsList
    Scaffold(
        topBar = {
            SearchBar(
                query = viewModel.query.value,
                handler = handler,
                onQueryChanged = viewModel::handleQueryChanged,
                onSubmitSearch = { viewModel.onTriggerEvent(SearchSongsEvent) }
            )
        }
    ) {
        SongList(songs = songs.value , handleSongCardClick ={
//            val song = Uri.encode(Gson().toJson(it))
//            val song = 123
//            navController.popBackStack()
//            navController.navigate("${Screens.ChordsScreen.route}/$it")
        },
        handleAddToFavoritesClick = {

            val song = Song(
                artist = it.artist,
                name = it.name,
                fullUrl = it.fullUrl,
                chordsLink = it.chordsLink,
                votes = it.meta.votes,
                rating = it.meta.rating,
//                lastViewedTimestamp = Date().time
            )
            viewModel.insertSongToPlaylist(song)
        })
    }
}