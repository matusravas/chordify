package project.mr.chordify.model.domain


data class SongPlaylist(
    val id: Long? = null,
    val song: Song,
    val playlist: Playlist,
    val isFavorite: Boolean = playlist.id == song.id,
)
