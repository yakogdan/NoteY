package com.yakogdan.notey.data.database.room.dao

import androidx.room.*
import com.yakogdan.notey.data.database.room.entities.NoteDbEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteRoomDao {

    @Query("SELECT * FROM notes_table")
    fun getAllNotes(): Flow<List<NoteDbEntity>>

    @Insert
    suspend fun addNote(noteDbEntity: NoteDbEntity)

    @Update
    suspend fun updateNote(noteDbEntity: NoteDbEntity)

    @Delete
    suspend fun deleteNote(noteDbEntity: NoteDbEntity)
}