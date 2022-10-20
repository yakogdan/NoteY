package com.yakogdan.notey.data.repository

import com.yakogdan.notey.data.storage.NotesStorage
import com.yakogdan.notey.data.storage.models.NoteModelStorage
import com.yakogdan.notey.domain.models.NoteDomain
import com.yakogdan.notey.domain.repository.NotesRepository


class NotesRepositoryImpl(private val notesStorage: NotesStorage) : NotesRepository {


    override fun saveData(noteDomain: NoteDomain): Boolean =
        notesStorage.saveData(mapToStorage(noteDomain))



    override fun getData(): NoteDomain {
        val note = notesStorage.getData()
        return mapToDomain(note)
    }

    private fun mapToDomain(note: NoteModelStorage): NoteDomain =
        NoteDomain(
            title = note.title,
            subtitle = note.subtitle
        )

    private fun mapToStorage(note: NoteDomain): NoteModelStorage =
        NoteModelStorage(
            title = note.title,
            subtitle = note.subtitle
        )

//    {
//        val title = sharedPreferences.getString(KEY_NAME, "")
//        return NoteDomain(title = title.toString())
//    }


//    private val database = App.database
//
//    override suspend fun getAllNotes(): List<NoteDomain> =
//        noteyRepository.getAllNotes().map(NoteyMapper::mapDbToDomain)
//
//
//    override suspend fun addNote(noteDomain: NoteDomain) {
//        noteyRepository.addNote(NoteyMapper.mapDomainToDb(noteDomain))
//    }
//
//    override suspend fun updateNote(noteDomain: NoteDomain) {
//        noteyRepository.updateNote(NoteyMapper.mapDomainToDb(noteDomain))
//    }
//
//    override suspend fun deleteNote(noteDomain: NoteDomain) {
//        noteyRepository.deleteNote(NoteyMapper.mapDomainToDb(noteDomain))
//    }

}