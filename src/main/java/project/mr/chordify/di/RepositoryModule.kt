package project.mr.chordify.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import project.mr.chordify.api.APIService
import project.mr.chordify.repository.Repository
import project.mr.chordify.repository.RepositoryImpl
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

//    @Singleton
    @ViewModelScoped
    @Provides
    fun provideRepository(apiService: APIService): Repository {
        return RepositoryImpl(apiService = apiService)
    }
}