package project.mr.chordify.model.domain

data class Song(
    val id: Long? = null,
    val artist: String,
    val name: String,
    var isFavorite: Boolean = false,
    val fullUrl: String,
    val chordsLink: String,
    val timestampLastViewed: Long? = null,
    val meta: SongMetadata
)
