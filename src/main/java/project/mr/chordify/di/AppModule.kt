package project.mr.chordify.di


import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import project.mr.chordify.database.AppDatabase
import project.mr.chordify.database.daos.SongsDao
import project.mr.chordify.model.entities.Playlist
import project.mr.chordify.presentation.BaseApplication
import java.util.Date
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext app: Context) =
        Room.databaseBuilder(app, AppDatabase::class.java, "chordify")
            .addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    db.execSQL("INSERT INTO playlist (name, timestamp_created) VALUES ('Favorites', ${Date().time})")

                }
            })
            .build()


    @Singleton
    @Provides
    fun provideSongsDao(db: AppDatabase) = db.songsDao()


//    @Singleton
//    @Provides
//    fun provideDatabase(@ApplicationContext app: Context): RoomDatabase {
//        return Room.databaseBuilder(app, AppDatabase::class.java, "chordify").build()
//    }
//
//    @Singleton
//    @Provides
//    fun provideSongsDao(db: AppDatabase): SongsDao {
//        return db.songsDao()
//    }

}