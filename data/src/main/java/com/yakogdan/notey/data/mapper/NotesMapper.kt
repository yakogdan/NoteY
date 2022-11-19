package com.yakogdan.notey.data.mapper

import com.yakogdan.notey.data.database.room.entities.NoteDbEntity
import com.yakogdan.notey.domain.entities.NoteDomainEntity

object NotesMapper {

    fun mapDbToDomain(noteDbEntity: NoteDbEntity): NoteDomainEntity =
        NoteDomainEntity(
            id = noteDbEntity.id,
            title = noteDbEntity.title,
            subtitle = noteDbEntity.subtitle,
            date = noteDbEntity.date
        )

    fun mapDomainToDbWithoutId(noteDomainEntity: NoteDomainEntity): NoteDbEntity = NoteDbEntity(
        title = noteDomainEntity.title,
        subtitle = noteDomainEntity.subtitle,
        date = noteDomainEntity.date
    )

    fun mapDomainToDb(noteDomainEntity: NoteDomainEntity): NoteDbEntity = NoteDbEntity(
        id = noteDomainEntity.id,
        title = noteDomainEntity.title,
        subtitle = noteDomainEntity.subtitle,
        date = noteDomainEntity.date
    )
}