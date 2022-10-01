package project.mr.chordify.presentation.ui.song_list

import android.net.Uri
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavController
import com.google.gson.Gson
import project.mr.chordify.presentation.components.SearchBar
import project.mr.chordify.presentation.components.SongList
import project.mr.chordify.presentation.vm.RestApiEvents.*
import project.mr.chordify.presentation.vm.SongListViewModel
import project.mr.chordify.navigation.routes.Screens

@ExperimentalComposeUiApi
@Composable
fun SearchScreen(navController: NavController, viewModel: SongListViewModel) {
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
        SongList(songs = songs.value , onItemClick = {
            val song = Uri.encode(Gson().toJson(it))
//            val song = 123
//            navController.popBackStack()
            navController.navigate("${Screens.HomeScreen.route}/$song")
        })
    }
}