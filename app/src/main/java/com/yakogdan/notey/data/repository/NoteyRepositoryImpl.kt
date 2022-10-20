package com.yakogdan.notey.data.repository

import android.content.Context
import com.yakogdan.notey.domain.models.NoteDomain
import com.yakogdan.notey.domain.repository.NoteyRepository

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_NAME = "title"
private const val DEFAULT_TITLE = "Default title"

class NoteyRepositoryImpl(context: Context) : NoteyRepository {
    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun saveData(noteDomain: NoteDomain): Boolean {
        sharedPreferences.edit().putString(KEY_NAME, noteDomain.title).apply()
        return true
    }

    override fun getData(): NoteDomain =
        NoteDomain(title = sharedPreferences.getString(KEY_NAME, DEFAULT_TITLE).toString())
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