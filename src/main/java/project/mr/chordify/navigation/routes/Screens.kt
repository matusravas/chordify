package project.mr.chordify.navigation.routes

sealed class Screens (val route: String){
//    object HomeRoute: RootRoutes("home")
    object SearchScreen: Screens("search")
    object HomeScreen: Screens("home")
}