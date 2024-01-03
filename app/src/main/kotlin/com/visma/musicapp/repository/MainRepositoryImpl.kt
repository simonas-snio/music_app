package com.visma.musicapp.repository

import androidx.datastore.core.DataStore
import com.musicapp.proto.Songs
import com.visma.musicapp.data.mock.data
import com.visma.musicapp.data.models.Category
import com.visma.musicapp.data.models.Song
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainRepositoryImpl
@Inject constructor(private val songsDataStore: DataStore<Songs>) : MainRepository {

    override fun getData(): List<Category> {
        return data
    }

    override suspend fun getStoredSongs(): Flow<Songs> {
        return songsDataStore.data
    }

    override suspend fun deleteSong(songId: Int) {
        songsDataStore.updateData { currSongs ->
            val updatedSongsList = currSongs.songList.filterNot { it.id == songId }
            currSongs.toBuilder()
                .clearSong()
                .addAllSong(updatedSongsList)
                .build()
        }
    }

    override suspend fun storeSong(song: Song) {
        songsDataStore.updateData { currSongs ->
            currSongs.toBuilder()
                .addSong(
                    com.musicapp.proto.Song.newBuilder()
                        .setId(song.id)
                        .setTitle(song.title)
                        .setDuration(song.duration)
                        .setSize(song.size)
                        .setStorageType(com.musicapp.proto.Song.StorageType.FILESYSTEM)
                        .build()
                )
                .build()
        }
    }
}