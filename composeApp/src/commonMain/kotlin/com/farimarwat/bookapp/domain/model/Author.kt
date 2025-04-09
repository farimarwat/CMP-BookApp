package com.farimarwat.bookapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Author(
    val key: String,
    val name: String
)