package project.mr.chordify.model.entities.pojo

data class LastViewedSong(
    val artist: String,
    val name: String,
    val lastViewedTimestamp: Long?
)