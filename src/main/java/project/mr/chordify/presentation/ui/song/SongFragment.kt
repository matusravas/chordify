package project.mr.chordify.presentation.ui.song

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import project.mr.chordify.presentation.BaseApplication
import project.mr.chordify.presentation.vm.SongViewModel
import project.mr.chordify.ui.theme.ChordifyTheme
import javax.inject.Inject

val TAG = SongFragment::class.simpleName

@AndroidEntryPoint
class SongFragment: Fragment() {

//    @Inject
//    lateinit var application: BaseApplication

    private val viewmodel: SongViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        arguments?.getParcelable<Song>("song")?.let{
//            viewmodel.onTriggerEvent(SearchChordsEvent(it))
//        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val songChords = viewmodel.songChords.value
                val scaffoldState = rememberScaffoldState()
                ChordifyTheme(
//                    isLoading = viewmodel.isLoading.value,
                    scaffoldState = scaffoldState
                ) {
                    Scaffold(
                        topBar = {

                        }
                    ) {
                        Text(text = songChords ?: "No data found")
                    }
                }
            }
        }
    }

}