package com.visma.musicapp.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.visma.musicapp.data.models.Category
import com.visma.musicapp.data.models.Song
import com.visma.musicapp.data.models.StorageType
import com.visma.musicapp.repository.MainRepository
import com.visma.musicapp.utils.toDataObject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepository: MainRepository) : ViewModel() {

    val data = mainRepository.getData()
    private val _allSongs = mutableStateListOf<Song>()
    val allSongs = _allSongs

    var songsByCategory = mutableStateOf<Category?>(null)
    var storageType = StorageType.MEMORY

    init {
        _allSongs.addAll(data.flatMap { it.songs })
        viewModelScope.launch {
            mainRepository.getStoredSongs().collect { storedSongs ->
                _allSongs.indices.forEach { index ->
                    val storedSong = storedSongs.songList.find { it.id == _allSongs[index].id }
                    storedSong?.let {
                        _allSongs[index] = it.toDataObject()
                    }
                }
            }
        }
    }

    fun setStorage(newStorageType: StorageType, callback: () -> Unit){
        storageType = newStorageType
        callback()
    }

    fun getSongsByCategory(categoryId: Int) {
        songsByCategory.value = data.find {
            it.id == categoryId
        }
    }

    fun saveSong(song: Song) {
        viewModelScope.launch {
            val index = allSongs.indexOfFirst { it.id == song.id }
            when (storageType) {
                StorageType.MEMORY -> {
                    if (index >= 0) {
                        allSongs.getOrNull(index)?.let { song ->
                            if (song.storageType == StorageType.FILESYSTEM) {
                                mainRepository.deleteSong(song.id)
                            }
                            allSongs[index] =
                                song.copy(storageType = if (song.storageType != StorageType.MEMORY) StorageType.MEMORY else StorageType.NONE)
                        }
                    }
                }

                StorageType.FILESYSTEM -> {
                    if (index >= 0) {
                        if (song.storageType != StorageType.FILESYSTEM) {
                            mainRepository.storeSong(song)
                        } else {
                            mainRepository.deleteSong(song.id)
                            allSongs[index] = song.copy(storageType = StorageType.NONE)
                        }
                    }
                }
                StorageType.NONE -> {}
            }
        }
    }
}
