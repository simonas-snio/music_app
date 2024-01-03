package com.visma.musicapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.visma.musicapp.data.models.StorageType


@Composable
fun Storage(memoryTime: String, fileSystemTime: String, onClick: (StorageType) -> Unit) {

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 8.dp)) {
        Text(text = "Storage", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        Row(modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick(StorageType.MEMORY)
            }
            .padding(vertical = 8.dp)
        ) {
            Text(text = StorageType.MEMORY.name)
            Spacer(modifier = Modifier.weight(1f))
            Text(text = memoryTime)
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                tint = Color.Gray,
                contentDescription = "Navigate"
            )
        }
        Divider(thickness = 1.dp, color = Color.Gray)
        Row(modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick(StorageType.FILESYSTEM)
            }
            .padding(vertical = 8.dp)
        ) {
            Text(text = StorageType.FILESYSTEM.name)
            Spacer(modifier = Modifier.weight(1f))
            Text(text = fileSystemTime)
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                tint = Color.Gray,
                contentDescription = "Navigate"
            )
        }
        Divider(thickness = 1.dp, color = Color.Gray)
    }
}