package project.mr.chordify.ui.theme

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import project.mr.chordify.presentation.components.HorizontalDottedProgressBar

private val LightThemeColors = lightColors(

//    primary = Color(0xFF455A64),
//    primaryVariant = Color(0xFF607D8B),
//    onPrimary = Color(0xFFF7FFFE),
//    secondary = Color(0x74E57373),
//    secondaryVariant = Color(0xFF009688),
//    onSecondary = Color.Black,
//    error = RedErrorDark,
//    onError = RedErrorLight,
//    background = Grey1,
//    onBackground = Color.Black,
//    surface = Color.White,
//    onSurface = Color.Black,
)

//private val DarkThemeColors = darkColors(
//    primary = Blue700,
//    primaryVariant = Color.White,
//    onPrimary = Color.White,
//    secondary = Black1,
//    onSecondary = Color.White,
//    error = RedErrorLight,
//    background = Color.Black,
//    onBackground = Color.White,
//    surface = Black1,
//    onSurface = Color.White,
//)

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */

@Composable
fun ChordifyTheme(darkTheme: Boolean = isSystemInDarkTheme(),
                  scaffoldState: ScaffoldState,
                  content: @Composable () -> Unit
) {
//    Log.d("MAIN", isLoading.toString())
    MaterialTheme(
//        colors = if(darkTheme) DarkThemeColors else LightThemeColors,
        colors = LightThemeColors,
        typography = Typography,
        shapes = Shapes
    ){
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = if(!darkTheme) Color.White else Color.Black)
        ){
            content()
             //else content()
//            DefaultSnackbar(
//                snackbarHostState = scaffoldState.snackbarHostState,
//                onDismiss = {
//                    scaffoldState.snackbarHostState.currentSnackbarData?.dismiss()
//                },
//                modifier = Modifier.align(Alignment.BottomCenter)
//            )
        }

    }
}