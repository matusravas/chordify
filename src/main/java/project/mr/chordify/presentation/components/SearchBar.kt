package project.mr.chordify.presentation.components


import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

const val RUNNABLE_DELAYED_SEARCH_TOKEN = 5

@ExperimentalComposeUiApi
@Composable
fun SearchBar(
    query: String,
    handler: Handler,
    onQueryChanged: (query: String) -> Unit,
    onSubmitSearch: () -> Unit
) {
    Log.d("RECOMPOSE", "SEARCH_BAR")
    val keyboardController = LocalSoftwareKeyboardController.current
    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        color = Color.White,
        elevation = 12.dp,
    ) {
//        Column {
            Row(modifier = Modifier.fillMaxWidth()) {

                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    value = query,
                    onValueChange = {
                        onQueryChanged(it)
                        handler.removeCallbacksAndMessages(RUNNABLE_DELAYED_SEARCH_TOKEN)
                        handler.postDelayed({onSubmitSearch()}, RUNNABLE_DELAYED_SEARCH_TOKEN, 800)
                                    },
                    label = { Text(text = "Search") },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done,
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            onSubmitSearch()
                            keyboardController?.hide()
                        },
                    ),
                    leadingIcon = { Icon(Icons.Filled.Search, contentDescription = "Search Icon")},
                    trailingIcon = {
                        if(query.isNotEmpty()) {Icon(
                        Icons.Filled.Clear,
                        contentDescription = "Clear Icon",
                        modifier = Modifier.clickable {
                            onQueryChanged("")
                            onSubmitSearch()
                        }
                    )}},
                    textStyle = TextStyle(color = MaterialTheme.colors.onSurface),
                    colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colors.surface),
                )
            }
//        }
    }
}