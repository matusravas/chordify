package project.mr.chordify.model.domain.pojo

data class LastViewedSong(
    val artist: String,
    val name: String,
    val lastViewedTimestamp: Long?
)