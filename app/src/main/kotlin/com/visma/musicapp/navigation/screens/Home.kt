package com.visma.musicapp.navigation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.visma.musicapp.data.mock.data
import com.visma.musicapp.data.models.StorageType
import com.visma.musicapp.navigation.Screen
import com.visma.musicapp.ui.components.CategoryCard
import com.visma.musicapp.ui.components.Storage
import com.visma.musicapp.utils.calculateTotalTime
import com.visma.musicapp.viewmodels.MainViewModel

@Composable
fun Home(navController: NavController, mainViewModel: MainViewModel) {

    Column {
        Spacer(modifier = Modifier.height(24.dp))
        LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
            items(data) { category ->
                CategoryCard(
                    category = category,
                    onClick = { id -> navController.navigate(Screen.CategorySongs.withArgs(id)) })
            }
            item {
                Storage(
                    memoryTime = mainViewModel.allSongs.calculateTotalTime(StorageType.MEMORY),
                    fileSystemTime = mainViewModel.allSongs.calculateTotalTime(StorageType.FILESYSTEM),
                    onClick = { type ->
                        mainViewModel.setStorage(type){
                            navController.navigate(Screen.SavedSongs.route)
                        }
                    })
                Spacer(modifier = Modifier.height(WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding())
                )
            }
        }
    }
}