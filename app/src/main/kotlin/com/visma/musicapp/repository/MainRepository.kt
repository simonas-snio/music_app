package com.visma.musicapp.repository


import com.musicapp.proto.Songs
import com.visma.musicapp.data.models.Category
import com.visma.musicapp.data.models.Song
import kotlinx.coroutines.flow.Flow

interface MainRepository {

    fun getData(): List<Category>

    suspend fun getStoredSongs(): Flow<Songs>

    suspend fun deleteSong(songId: Int)

    suspend fun storeSong(song: Song)

}