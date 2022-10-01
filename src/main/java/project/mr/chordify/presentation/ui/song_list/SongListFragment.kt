package project.mr.chordify.presentation.ui.song_list


import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import dagger.hilt.android.AndroidEntryPoint
import project.mr.chordify.R
import project.mr.chordify.presentation.BaseApplication
import project.mr.chordify.presentation.components.SearchBar
import project.mr.chordify.presentation.components.SongList
import project.mr.chordify.presentation.vm.SongEvent.*
import project.mr.chordify.presentation.vm.SongListViewModel
import project.mr.chordify.ui.theme.ChordifyTheme
import javax.inject.Inject

@ExperimentalComposeUiApi
@AndroidEntryPoint
class SongListFragment: Fragment() {

    @Inject
    lateinit var application: BaseApplication

    private val viewmodel: SongListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewmodel.onTriggerEvent(NewSongsSearchEvent)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val songs = viewmodel.searchedSongsList.value
                val scaffoldState = rememberScaffoldState()
                val handler = Handler(Looper.getMainLooper())
                ChordifyTheme(
                    isLoading = viewmodel.isLoading.value,
                    scaffoldState = scaffoldState
                ) {
                    Scaffold(
                        topBar = {
                            SearchBar(
                                query = viewmodel.query.value,
                                handler = handler,
                                onQueryChanged = viewmodel::handleQueryChanged,
                                onSubmitSearch = { viewmodel.onTriggerEvent(NewSongsSearchEvent) }
                            )
                        }
                    ) {
                        SongList(songs = songs , onItemClick = {
                            val bundle = Bundle()
                            bundle.putParcelable("song", it)
                            findNavController().navigate(R.id.viewSong, bundle)
                        })
                    }
                }
            }
        }
    }

}