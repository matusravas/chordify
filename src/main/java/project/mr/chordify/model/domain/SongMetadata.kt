package project.mr.chordify.model.domain

data class SongMetadata(
    val votes: Int,
    val rating: Float,
    val score: Float,
    val hits: Int? = null
)