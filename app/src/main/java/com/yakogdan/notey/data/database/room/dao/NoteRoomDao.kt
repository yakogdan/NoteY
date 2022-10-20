package com.yakogdan.notey.data.database.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.yakogdan.notey.data.database.room.entities.DbNoteEntity

@Dao
interface NoteRoomDao {

    @Query("SELECT * FROM notes_table")
    suspend fun getAllNotes(): List<DbNoteEntity>

    @Insert
    suspend fun addNote(dbNoteEntity: DbNoteEntity)

    @Update
    suspend fun updateNote(dbNoteEntity: DbNoteEntity)

    @Delete
    suspend fun deleteNote(dbNoteEntity: DbNoteEntity)
}