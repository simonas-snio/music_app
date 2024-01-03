package com.visma.musicapp.utils

import androidx.navigation.NavController
import com.visma.musicapp.data.models.Song
import com.visma.musicapp.data.models.StorageType
import com.visma.musicapp.navigation.Screen

fun Int.formatSongTime(): String {
    val hours = this / 3600
    val remainingMinutes = (this % 3600) / 60
    val remainingSeconds = this % 60

    return when {
        hours > 0 && remainingMinutes > 0 -> "$hours h $remainingMinutes m $remainingSeconds s"
        remainingMinutes > 0 -> "$remainingMinutes m $remainingSeconds s"
        else -> "$remainingSeconds s"
    }
}

fun List<Song>.calculateTotalTime(storageType: StorageType): String {
    return this.filter { it.storageType == storageType }.sumOf { it.duration }.formatSongTime()

}

fun Song.isStored(storageType: StorageType): Boolean {
    return this.storageType == storageType
}

fun com.musicapp.proto.Song.toDataObject(storageType: StorageType = StorageType.FILESYSTEM): Song{
    return Song(this.id, this.title, this.duration, this.size, storageType)
}
fun NavController.goHome(){
    if(!this.popBackStack()){
        this.navigate(Screen.Home.route)
    }
}