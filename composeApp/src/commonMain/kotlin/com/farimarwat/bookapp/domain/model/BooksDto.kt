package com.farimarwat.bookapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class BooksDto(
    val key: String,
    val name: String,
    val subject_type: String,
    val work_count: Int,
    val works: List<Work>
)