package project.mr.chordify.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import project.mr.chordify.model.api.SongMapperApi
import project.mr.chordify.model.entities.PlaylistMapperDb
import project.mr.chordify.model.entities.SongMapperDb
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideSongApiMapper() = SongMapperApi()

    @Singleton
    @Provides
    fun provideSongDbMapper() = SongMapperDb()

    @Singleton
    @Provides
    fun providePlaylistDbMapper() = PlaylistMapperDb()

}