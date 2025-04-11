package com.farimarwat.bookapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class RatingDto(
    val counts: Counts,
    val summary: Summary
)