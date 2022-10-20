package com.yakogdan.notey.data.storage

import android.content.Context
import com.yakogdan.notey.data.storage.models.NoteModelStorage
import com.yakogdan.notey.domain.models.NoteDomain

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_NAME = "title"
private const val DEFAULT_TITLE = "Default title"

// Это локальное хранилище

class SharedPrefNotesStorage(context: Context) : NotesStorage {

    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun saveData(noteModelStorage: NoteModelStorage): Boolean {
        sharedPreferences.edit().putString(KEY_NAME, noteModelStorage.title).apply()
        return true
    }

    override fun getData(): NoteModelStorage =
        NoteModelStorage(title = sharedPreferences.getString(KEY_NAME, DEFAULT_TITLE).toString())
}