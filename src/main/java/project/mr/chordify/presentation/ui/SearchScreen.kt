package project.mr.chordify.presentation.ui

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import project.mr.chordify.presentation.components.SearchBar
import project.mr.chordify.presentation.components.SongList
import project.mr.chordify.presentation.vm.DatabaseEvents
import project.mr.chordify.presentation.vm.RestApiEvents.*
import project.mr.chordify.presentation.vm.SongListSearchViewModel

@ExperimentalComposeUiApi
@Composable
fun SearchScreen(viewModel: SongListSearchViewModel) {
//    Todo create own navController and use ne navHost setup
    val handler = remember {Handler(Looper.getMainLooper())}
    LaunchedEffect(viewModel){
        Log.d("LAUNCHED", "COROUTINE")
        viewModel.onTriggerApiEvent(SearchSongsEvent)
    }
//    Log.d("COMPOSABLE", "HERE")
    val isLoading = viewModel.isLoading.value
    Log.d("RECOMPOSE", "SEARCH_SCREEN")
    Scaffold(
        topBar = {
            SearchBar(
                query = viewModel.query.value,
                handler = handler,
                onQueryChanged = viewModel::handleQueryChanged,
                onSubmitSearch = { viewModel.onTriggerApiEvent(SearchSongsEvent) }
            )
        }
    ) {
        SongList(songs = viewModel.searchedSongsList.value , handleSongCardClick ={
//            val song = Uri.encode(Gson().toJson(it))
//            val song = 123
//            navController.popBackStack()
//            navController.navigate("${Screens.ChordsScreen.route}/$it")
        },
        handleAddToFavoritesClick = {
            viewModel.onTriggerDbEvent(DatabaseEvents.AddSongToPlaylistEvent(it, 1))
        })
    }
}