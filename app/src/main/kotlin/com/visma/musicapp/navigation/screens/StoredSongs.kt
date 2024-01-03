package com.visma.musicapp.navigation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.visma.musicapp.ui.components.SongListElement
import com.visma.musicapp.utils.goHome
import com.visma.musicapp.viewmodels.MainViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SavedSongs(navController: NavController, mainViewModel: MainViewModel) {

    Column {
        TopAppBar(
            title = { Text(text = mainViewModel.storageType.name) }, navigationIcon = {
                IconButton(onClick = { navController.goHome() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "",
                    )
                }
            }
        )
        Spacer(modifier = Modifier.height(24.dp))
        LazyColumn(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            items(mainViewModel.allSongs) { song ->
                SongListElement(
                    song = song,
                    showStoreStatus = true,
                    storageType = mainViewModel.storageType,
                    saveSong = { savedSong ->
                        mainViewModel.saveSong(
                            song = savedSong
                        )
                    })
                Divider(
                    color = Color.Black,
                    thickness = 1.dp,
                    modifier = Modifier.padding(top = 1.dp)
                )
            }
            item {
                Spacer(
                    modifier = Modifier.height(
                        WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()
                    )
                )
            }

        }
    }
}