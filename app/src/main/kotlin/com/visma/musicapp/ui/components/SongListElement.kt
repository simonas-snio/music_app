package com.visma.musicapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.visma.musicapp.R
import com.visma.musicapp.data.models.Song
import com.visma.musicapp.data.models.StorageType
import com.visma.musicapp.utils.formatSongTime
import com.visma.musicapp.utils.isStored


@Composable
fun SongListElement(
    song: Song,
    showStoreStatus: Boolean,
    storageType: StorageType = StorageType.MEMORY,
    saveSong: (Song) -> Unit = {}
) {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Column(modifier = Modifier.weight(0.9F)) {
            Text(text = song.title, maxLines = 1, overflow = TextOverflow.Ellipsis)
            Text(text = "${song.size}MB - ${song.duration.formatSongTime()}", fontSize = 11.sp)
        }
        if (showStoreStatus) {
            IconButton(onClick = { saveSong(song) }, modifier = Modifier.weight(0.1F)) {
                Icon(
                    painter = painterResource(id = if (song.isStored(storageType)) R.drawable.ic_check else R.drawable.ic_save),
                    tint = if (song.isStored(storageType)) Color.Gray else Color.Blue,
                    contentDescription = "Store status"
                )
            }
        }
    }

}