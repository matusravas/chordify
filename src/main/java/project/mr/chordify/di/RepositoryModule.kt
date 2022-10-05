package project.mr.chordify.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import project.mr.chordify.api.APIService
import project.mr.chordify.database.daos.Dao
import project.mr.chordify.model.api.SongMapperApi
import project.mr.chordify.model.entities.PlaylistMapperDb
import project.mr.chordify.model.entities.SongMapperDb
import project.mr.chordify.repository.Repository
import project.mr.chordify.repository.Repository_Impl


@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @ViewModelScoped
    @Provides
    fun provideRepository(apiService: APIService, dao: Dao,
                          songMapperApi: SongMapperApi,
                          songMapperDb: SongMapperDb,
                          playlistMapperDb: PlaylistMapperDb): Repository {
        return Repository_Impl(
            apiService = apiService,
            dao = dao,
            songMapperApi = songMapperApi,
            songMapperDb = songMapperDb,
            playlistMapperDb = playlistMapperDb)
    }
}