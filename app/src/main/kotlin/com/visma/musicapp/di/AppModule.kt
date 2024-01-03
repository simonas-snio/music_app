package com.visma.musicapp.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import com.musicapp.proto.Songs
import com.visma.musicapp.datastore.SongsSerializer
import com.visma.musicapp.repository.MainRepository
import com.visma.musicapp.repository.MainRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesMainRepository(
        songsDataStore: DataStore<Songs>
    ): MainRepository {
        return MainRepositoryImpl(songsDataStore)
    }

    @Singleton
    @Provides
    fun provideDataStore(@ApplicationContext appContext: Context): DataStore<Songs> {
        return DataStoreFactory.create(
            serializer = SongsSerializer
        ) {
            appContext.dataStoreFile("songs.pb")
        }
    }
}
