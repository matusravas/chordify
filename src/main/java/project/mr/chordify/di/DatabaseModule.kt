package project.mr.chordify.di


import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import project.mr.chordify.database.AppDatabase
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.util.Date
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

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
    fun provideDao(db: AppDatabase) = db.getDao()
//
//
////    @Singleton
////    @Provides
////    fun provideDatabase(@ApplicationContext app: Context): RoomDatabase {
////        return Room.databaseBuilder(app, AppDatabase::class.java, "chordify").build()
////    }
////
////    @Singleton
////    @Provides
////    fun provideSongsDao(db: AppDatabase): SongsDao {
////        return db.songsDao()
////    }

}