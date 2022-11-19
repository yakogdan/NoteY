package com.yakogdan.notey.domain.entities

data class NoteDomainEntity(
    val id: Int = 0,
    val title: String,
    val subtitle: String,
    val date: String
) : java.io.Serializable