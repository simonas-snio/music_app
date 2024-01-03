package com.visma.musicapp.data.models

enum class StorageType(name: String) {
    MEMORY(name = "Memory"),
    FILESYSTEM(name = "Filesystem"),
    NONE("none")
}

data class Song(
    val id: Int,
    val title: String,
    val duration: Int,
    val size: Int,
    var storageType: StorageType = StorageType.NONE
)
