package com.yakogdan.notey.data.storage

import com.yakogdan.notey.data.storage.models.NoteModelStorage
import com.yakogdan.notey.domain.models.NoteDomain

interface NotesStorage {
    fun saveData(noteModelStorage: NoteModelStorage): Boolean

    fun getData(): NoteModelStorage
}