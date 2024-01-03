package com.visma.musicapp.navigation

sealed class Screen(val route: String) {
    object Home : Screen("/home")
    object CategorySongs : Screen("/category-songs")
    object SavedSongs : Screen("/saved-songs")

    fun withArgs(vararg args: Any?): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}