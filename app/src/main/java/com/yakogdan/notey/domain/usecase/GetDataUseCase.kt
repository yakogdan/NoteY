package com.yakogdan.notey.domain.usecase

import com.yakogdan.notey.domain.models.NoteDomain
import com.yakogdan.notey.domain.repository.NotesRepository

class GetDataUseCase(private val notesRepository: NotesRepository) {

    fun execute(): NoteDomain = notesRepository.getData()
}