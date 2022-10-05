package project.mr.chordify.model.entities

import project.mr.chordify.model.domain.DomainMapper
import project.mr.chordify.model.domain.Song
import project.mr.chordify.model.entities.Song as SongDto
import project.mr.chordify.model.domain.SongMetadata
import java.util.*

class SongMapperDb: DomainMapper<SongDto, Song>{

    override fun mapToDomainModel(m: SongDto): Song {
        return Song(
            id = m.id,
            artist = m.artist,
            name = m.name,
            chordsLink = m.chordsLink,
            fullUrl = m.fullUrl,
            timestampLastViewed = m.timestampLastViewed,
            meta = SongMetadata(
                votes = m.votes,
                rating = m.rating,
                hits = null,
                score = m.score
            )
        )
    }

    override fun mapFromDomainModel(m: Song): SongDto {
        return SongDto(
            artist = m.artist,
            name = m.name,
            chordsLink = m.chordsLink,
            fullUrl = m.fullUrl,
            timestampLastViewed = m.timestampLastViewed,
            votes = m.meta.votes,
            rating = m.meta.rating,
            score = m.meta.score
        )
    }
    
    fun toDomainList(list: List<SongDto>) = list.map { mapToDomainModel(it) }

    fun fromDomainList(list: List<Song>) = list.map { mapFromDomainModel(it) }
}