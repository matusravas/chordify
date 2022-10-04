package project.mr.chordify.database

import androidx.room.Database
import androidx.room.RoomDatabase
import project.mr.chordify.database.daos.SongsDao
import project.mr.chordify.model.entities.Playlist
import project.mr.chordify.model.entities.Song
import project.mr.chordify.model.entities.SongPlaylist

@Database(entities = [Song::class, Playlist::class, SongPlaylist::class], version = 1)
abstract class AppDatabase: RoomDatabase(){
    abstract fun songsDao(): SongsDao
}