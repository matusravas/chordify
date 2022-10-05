package project.mr.chordify.model.domain

interface DomainMapper <U, T> {

    fun mapToDomainModel(m: U): T

    fun mapFromDomainModel(m: T): U
}