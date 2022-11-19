package com.yakogdan.notey.di

import android.content.Context
import com.yakogdan.notey.data.database.room.AppRoomDatabase
import com.yakogdan.notey.data.database.room.dao.NoteRoomDao
import com.yakogdan.notey.data.repository.NotesRepositoryImpl
import com.yakogdan.notey.domain.repository.NotesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun provideNotesRepository(noteRoomDao: NoteRoomDao): NotesRepository {
        return NotesRepositoryImpl(noteRoomDao)
    }

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppRoomDatabase {
        return AppRoomDatabase.create(context)
    }

    @Provides
    fun provideDao(appRoomDatabase: AppRoomDatabase): NoteRoomDao {
        return appRoomDatabase.getNoteDao()
    }
}