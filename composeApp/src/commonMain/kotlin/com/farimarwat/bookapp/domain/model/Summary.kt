package com.farimarwat.bookapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Summary(
    val average: Double,
    val count: Int,
    val sortable: Double
)