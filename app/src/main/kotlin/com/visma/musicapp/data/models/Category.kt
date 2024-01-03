package com.visma.musicapp.data.models

data class Category(
    val id: Int,
    val name: String,
    val songs: List<Song>
)
