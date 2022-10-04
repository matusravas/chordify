package project.mr.chordify.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import project.mr.chordify.api.APIService
import project.mr.chordify.database.daos.SongsDao
import project.mr.chordify.repository.api.RepositoryAPI
import project.mr.chordify.repository.api.RepositoryAPI_Impl
import project.mr.chordify.repository.db.RepositoryDB
import project.mr.chordify.repository.db.Repository_DB_Impl


//@Module
//@InstallIn(ViewModelComponent::class)
//abstract class RepositoryDBModule {
//
//    @ViewModelScoped
//    @Binds
//    abstract fun provideDatabaseRepository(repo: Repository_DB_Impl): RepositoryDB
//}