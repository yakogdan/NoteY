package com.yakogdan.notey.domain.usecase

import com.yakogdan.notey.domain.models.NoteDomain
import com.yakogdan.notey.domain.repository.NoteyRepository

class GetDataUseCase(private val noteyRepository: NoteyRepository) {

    fun execute(): NoteDomain = noteyRepository.getData()
}