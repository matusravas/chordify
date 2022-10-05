package project.mr.chordify.model.entities

import project.mr.chordify.model.domain.DomainMapper
import project.mr.chordify.model.domain.Playlist
import project.mr.chordify.model.entities.Playlist as PlaylistDto
import project.mr.chordify.model.domain.SongMetadata
import java.util.*

class PlaylistMapper: DomainMapper<PlaylistDto, Playlist>{

    override fun mapToDomainModel(m: PlaylistDto): Playlist {
        return Playlist(
            id = m.id,
            name = m.name,
            timestampCreated = m.timestampCreated
        )
    }

    override fun mapFromDomainModel(m: Playlist): PlaylistDto {
        return PlaylistDto(
            name = m.name,
            timestampCreated = Date().time
        )
    }
    
    fun toDomainList(list: List<PlaylistDto>) = list.map { mapToDomainModel(it) }

    fun fromDomainList(list: List<Playlist>) = list.map { mapFromDomainModel(it) }
}