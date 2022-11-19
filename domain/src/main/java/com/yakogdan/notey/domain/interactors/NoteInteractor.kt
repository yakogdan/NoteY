package com.yakogdan.notey.domain.interactors

import com.yakogdan.notey.domain.entities.NoteDomainEntity
import com.yakogdan.notey.domain.repository.NotesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteInteractor @Inject constructor(private val notesRepository: NotesRepository) {

    suspend fun getAllNotes(): Flow<List<NoteDomainEntity>> =
        notesRepository.getAllNotes()

    suspend fun addNote(noteDomainEntity: NoteDomainEntity) =
        notesRepository.addNote(noteDomainEntity)

    suspend fun updateNote(noteDomainEntity: NoteDomainEntity) =
        notesRepository.updateNote(noteDomainEntity)

    suspend fun deleteNote(noteDomainEntity: NoteDomainEntity) =
        notesRepository.deleteNote(noteDomainEntity)
}