package project.mr.chordify.model.entities

import project.mr.chordify.model.domain.DomainMapper
import project.mr.chordify.model.domain.SongPlaylist
import project.mr.chordify.model.entities.SongPlaylist as SongPlaylistDto
import java.util.*

//class SongPlaylistMapper: DomainMapper<SongPlaylistDto, SongPlaylist>{
//
//    override fun mapToDomainModel(m: SongPlaylistDto): SongPlaylist {
//        return SongPlaylist(
////            id = m.id,
//
//        )
//    }
//
//    override fun mapFromDomainModel(m: SongPlaylist): SongPlaylistDto {
//        return SongPlaylistDto(
//
//        )
//    }
//
//    fun toDomainList(list: List<SongPlaylistDto>) = list.map { mapToDomainModel(it) }
//
//    fun fromDomainList(list: List<SongPlaylist>) = list.map { mapFromDomainModel(it) }
//}