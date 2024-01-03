package com.visma.musicapp.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.visma.musicapp.navigation.screens.CategorySongs
import com.visma.musicapp.navigation.screens.Home
import com.visma.musicapp.navigation.screens.SavedSongs
import com.visma.musicapp.viewmodels.MainViewModel

@Composable
fun Navigation(viewModel: MainViewModel = hiltViewModel()) {
    val navController = rememberNavController()

    NavHost(
        navController = navController, startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            Home(mainViewModel = viewModel, navController = navController)
        }
        composable(
            route = Screen.CategorySongs.route + "/{categoryId}",
            arguments = listOf(navArgument("categoryId") { type = NavType.IntType })
        ) {
            CategorySongs(
                navController = navController,
                mainViewModel = viewModel,
                categoryId = it.arguments!!.getInt("categoryId")
            )
        }
        composable(route = Screen.SavedSongs.route) {
            SavedSongs(navController = navController, mainViewModel = viewModel)
        }
    }
}