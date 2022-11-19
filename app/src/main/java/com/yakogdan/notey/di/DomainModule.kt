package com.yakogdan.notey.di

import com.yakogdan.notey.domain.interactors.NoteInteractor
import com.yakogdan.notey.domain.repository.NotesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideNoteInteractor(notesRepository: NotesRepository): NoteInteractor {
        return NoteInteractor(notesRepository)
    }
}