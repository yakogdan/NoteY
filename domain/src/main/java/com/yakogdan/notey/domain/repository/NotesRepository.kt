package com.yakogdan.notey.domain.repository

import com.yakogdan.notey.domain.entities.NoteDomainEntity
import kotlinx.coroutines.flow.Flow

interface NotesRepository {

    suspend fun getAllNotes(): Flow<List<NoteDomainEntity>>

    suspend fun addNote(noteDomainEntity: NoteDomainEntity)

    suspend fun updateNote(noteDomainEntity: NoteDomainEntity)

    suspend fun deleteNote(noteDomainEntity: NoteDomainEntity)
}