package com.farimarwat.bookapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class DetailsDto(
    val description: Description
)