package project.mr.chordify.navigation.routes


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigationScreens (val route: String, val label: String, val icon: ImageVector){
    object SearchScreen: BottomNavigationScreens("search", "Search", Icons.Filled.Search)
    object HomeScreen: BottomNavigationScreens("home", "Home", Icons.Filled.Home )
}

sealed class Screens (val route: String){
    object SearchScreen: Screens("search")
    object HomeScreen: Screens("home")
    object ChordsScreen: Screens("chords")
}

val screens = listOf(
    BottomNavigationScreens.SearchScreen,
    BottomNavigationScreens.HomeScreen
)