package com.yakogdan.notey.domain.repository

import com.yakogdan.notey.domain.models.NoteDomain

interface NotesRepository {

    fun saveData(noteDomain: NoteDomain): Boolean

    fun getData(): NoteDomain

//    suspend fun getAllNotes(): List<NoteDomain>
//
//    suspend fun addNote(noteDomain: NoteDomain)
//
//    suspend fun updateNote(noteDomain: NoteDomain)
//
//    suspend fun deleteNote(noteDomain: NoteDomain)
}