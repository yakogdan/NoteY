package com.yakogdan.notey.data.repository

import com.yakogdan.notey.data.database.room.dao.NoteRoomDao
import com.yakogdan.notey.data.mapper.NotesMapper
import com.yakogdan.notey.domain.entities.NoteDomainEntity
import com.yakogdan.notey.domain.repository.NotesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NotesRepositoryImpl @Inject constructor(
    private val dao: NoteRoomDao
    ): NotesRepository{

    override suspend fun getAllNotes(): Flow<List<NoteDomainEntity>> {
        return dao.getAllNotes().map { notes -> notes.map { NotesMapper.mapDbToDomain(it) } }
    }

    override suspend fun addNote(noteDomainEntity: NoteDomainEntity) {
        dao.addNote(NotesMapper.mapDomainToDbWithoutId(noteDomainEntity))
    }

    override suspend fun updateNote(noteDomainEntity: NoteDomainEntity) {
        dao.updateNote(NotesMapper.mapDomainToDb(noteDomainEntity))
    }

    override suspend fun deleteNote(noteDomainEntity: NoteDomainEntity) {
        dao.deleteNote(NotesMapper.mapDomainToDb(noteDomainEntity))
    }
}