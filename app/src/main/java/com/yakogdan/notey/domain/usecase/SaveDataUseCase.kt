package com.yakogdan.notey.domain.usecase

import com.yakogdan.notey.domain.models.NoteDomain
import com.yakogdan.notey.domain.repository.NotesRepository

class SaveDataUseCase(private val notesRepository: NotesRepository) {

    fun execute(noteDomain: NoteDomain): Boolean {

        val oldData = notesRepository.getData()
        if (oldData.title == noteDomain.title) return true
        // В реальности обычно такую логику делают на presentation слое

        return notesRepository.saveData(noteDomain)
    }

}