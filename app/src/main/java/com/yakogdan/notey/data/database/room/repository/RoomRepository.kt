package com.yakogdan.notey.data.database.room.repository

import androidx.lifecycle.LiveData
import com.yakogdan.notey.data.database.DatabaseRepository
//import com.yakogdan.notey.data.database.room.dao.NoteRoomDao
//import com.yakogdan.notey.data.database.room.entities.DbNoteEntity

//class RoomRepository (private val noteRoomDao: NoteRoomDao) : DatabaseRepository {
//    override val readAll: LiveData<List<DbNoteEntity>>
//        get() = readAll
//
//    override suspend fun create(dbNoteEntity: DbNoteEntity, onSuccess: () -> Unit) {
//        noteRoomDao.addNote(dbNoteEntity = dbNoteEntity)
//        onSuccess()
//    }
//
//    override suspend fun update(dbNoteEntity: DbNoteEntity, onSuccess: () -> Unit) {
//        noteRoomDao.updateNote(dbNoteEntity = dbNoteEntity)
//        onSuccess()
//    }
//
//    override suspend fun delete(dbNoteEntity: DbNoteEntity, onSuccess: () -> Unit) {
//        noteRoomDao.deleteNote(dbNoteEntity = dbNoteEntity)
//        onSuccess()
//    }
//
//    override fun signOut() {}
//}