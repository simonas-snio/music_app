package com.visma.musicapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.visma.musicapp.navigation.Navigation
import com.visma.musicapp.ui.theme.MusicAppTheme

@Composable
fun App() {
    MusicAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize().padding(horizontal = 8.dp),
            color = MaterialTheme.colorScheme.background
        ) {
            Navigation()
        }
    }
}