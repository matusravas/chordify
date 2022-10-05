package project.mr.chordify.model.api

import project.mr.chordify.model.domain.DomainMapper
import project.mr.chordify.model.domain.Song
import project.mr.chordify.model.domain.SongMetadata

class SongMapper: DomainMapper<SongDto, Song>{

    override fun mapToDomainModel(m: SongDto): Song {
        return Song(
            artist = m.artist,
            name = m.name,
            chordsLink = m.chordsLink,
            fullUrl = m.fullUrl,
            timestampLastViewed = null,
            meta = SongMetadata(
                votes = m.meta.votes,
                rating = m.meta.rating,
                hits = m.meta.hits,
                score = m.meta.score
            )
        )
    }

    override fun mapFromDomainModel(m: Song): SongDto {
        return SongDto(
            artist = m.artist,
            name = m.name,
            chordsLink = m.chordsLink,
            fullUrl = m.fullUrl,
            meta = SongMetadataDto(
                votes = m.meta.votes,
                rating = m.meta.rating,
                hits = m.meta.hits,
                score = m.meta.score
            )
        )
    }
    
    fun toDomainList(list: List<SongDto>) = list.map { mapToDomainModel(it) }

    fun fromDomainList(list: List<Song>) = list.map { mapFromDomainModel(it) }
}