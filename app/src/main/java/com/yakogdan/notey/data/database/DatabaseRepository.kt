package com.yakogdan.notey.data.database

import androidx.lifecycle.LiveData
import com.yakogdan.notey.data.database.room.entities.DbNoteEntity

interface DatabaseRepository {

    val readAll: LiveData<List<DbNoteEntity>>

    suspend fun create(dbNoteEntity: DbNoteEntity, onSuccess: () -> Unit)

    suspend fun update(dbNoteEntity: DbNoteEntity, onSuccess: () -> Unit)

    suspend fun delete(dbNoteEntity: DbNoteEntity, onSuccess: () -> Unit)

    fun signOut() {}

    fun connectToDatabase(onSuccess: () -> Unit, onFail: (String) -> Unit) {}
}