package com.yakogdan.notey.domain.usecase

import com.yakogdan.notey.domain.models.NoteDomain
import com.yakogdan.notey.domain.repository.NoteyRepository

class SaveDataUseCase(private val noteyRepository: NoteyRepository) {

    fun execute(noteDomain: NoteDomain): Boolean {

        val oldData = noteyRepository.getData()
        if (oldData.title == noteDomain.title) return true
        // В реальности обычно такую логику делают на presentation слое

        return noteyRepository.saveData(noteDomain)
    }

}