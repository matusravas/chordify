package project.mr.chordify.di


import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import project.mr.chordify.database.AppDatabase
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import project.mr.chordify.database.daos.SongsDao
import project.mr.chordify.presentation.BaseApplication
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

//    @Singleton
//    @Provides
//    fun provideDatabase(@ApplicationContext app: Context): RoomDatabase {
//        return Room.databaseBuilder(app, AppDatabase::class.java, "chordify").build()
//    }
//
//    @Singleton
//    @Provides
//    fun provideSongsDao(db: AppDatabase): SongsDao{
//        return db.songsDao()
//    }

}